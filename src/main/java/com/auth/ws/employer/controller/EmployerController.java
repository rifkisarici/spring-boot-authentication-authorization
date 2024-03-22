package com.auth.ws.employer.controller;

import com.auth.ws.employer.service.EmployerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/1.0/userEmployer")
public class EmployerController {
    private final EmployerService employerService;

    /*@PostMapping(path = "/candidateAdd")
    public GenericResponse register(@Valid @RequestBody UserCandidateRegistrationDTO userCandidateRegistrationDTO) {
        AppUser appUser = userService.register(userCandidateRegistrationDTO.getDomainAppUser());
        return userCandidateService.register(userCandidateRegistrationDTO.getDomainAppUserCandidate(appUser));
    }*/
}
