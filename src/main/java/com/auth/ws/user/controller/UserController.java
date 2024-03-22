package com.auth.ws.user.controller;

import com.auth.ws.company.entity.AppCompany;
import com.auth.ws.company.service.CompanyService;
import com.auth.ws.shared.annotations.CurrentUser;
import com.auth.ws.shared.responses.GenericResponse;
import com.auth.ws.user.controller.dto.*;
import com.auth.ws.user.entity.AppUser;
import com.auth.ws.user.service.UserService;
import com.auth.ws.candidate.service.CandidateService;
import com.auth.ws.employer.service.EmployerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/1.0/user")
public class UserController {
    private final UserService userService;
    private final CandidateService candidateService;
    private final EmployerService employerService;
    private final CompanyService companyService;

    @PostMapping(path = "/candidate")
    public GenericResponse register(@Valid @RequestBody UserCandidateRegistrationDTO userCandidateRegistrationDTO) {
        AppUser appUser = userService.register(userCandidateRegistrationDTO.getDomainAppUser());
        return candidateService.register(userCandidateRegistrationDTO.getDomainAppUserCandidate(appUser));
    }

    @PostMapping(path = "/employer")
    public GenericResponse register(@Valid @RequestBody UserEmployerRegistrationDTO userEmployerRegistrationDTO) {
        AppUser appUser = userService.register(userEmployerRegistrationDTO.getDomainAppUser());
        AppCompany appCompany=companyService.register(userEmployerRegistrationDTO.getDomainAppCompany());
        return employerService.register(userEmployerRegistrationDTO.getDomainAppEmployer(userEmployerRegistrationDTO.getName(),appUser, appCompany));
    }

    @GetMapping(path = "/userAll")
    public Page<UserDTO> getUserAll(Pageable page, @CurrentUser AppUser appUser) {
        /*return resumeService.getResume(page).stream()
                .map(p-> new ResumeDTO(p))
                .collect(Collectors.toList());
         */
        return userService.getUserAll(page, appUser).map(UserDTO::new)/*.stream().toList()*/;
    }


    @GetMapping(path = "/{username}")
    public UserDTO getUser(@PathVariable String username) {
        AppUser appUser = userService.getUserByUsername(username);
        return new UserDTO(appUser);
    }


    /*//TODO: PreAuthorize içerisinde UserRole doğrulaması yapılabilir. Ayrıca SecurityConfig içerisinde de yapılabilir.
    @PutMapping(path = "/putUser")
    public UserDTO updateUser(@Valid @RequestBody UserUpdateRegistration updatedUser, @CurrentUser AppUser appUser) {
        return (new UserDTO(userService.updateUser(updatedUser, appUser)));
    }*/





}
