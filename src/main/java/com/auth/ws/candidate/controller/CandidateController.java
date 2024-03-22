package com.auth.ws.candidate.controller;


import com.auth.ws.candidate.controller.dto.AboutRegistration;
import com.auth.ws.candidate.entity.AppCandidate;
import com.auth.ws.candidate.service.CandidateService;
import com.auth.ws.shared.annotations.CurrentUser;
import com.auth.ws.shared.responses.GenericResponse;
import com.auth.ws.user.entity.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/1.0/candidate")
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping(path = "/about")
    public GenericResponse saveAbout(@CurrentUser AppUser appUser, @Valid @RequestBody AboutRegistration aboutText) {
        AppCandidate appCandidate=candidateService.getCandidateByAppUser(appUser);
        return candidateService.saveAbout(appCandidate, aboutText.getAbout());
    }

    @PutMapping(path = "/about/update")
    public GenericResponse updateAbout(@CurrentUser AppUser appUser, @Valid @RequestBody AboutRegistration aboutText) {
        AppCandidate appCandidate=candidateService.getCandidateByAppUser(appUser);
        return candidateService.saveAbout(appCandidate, aboutText.getAbout());
    }

    @GetMapping("/about")
    public String getAbout(@CurrentUser AppUser appUser ) {
        AppCandidate appCandidate=candidateService.getCandidateByAppUser(appUser);
        return candidateService.getAbout(appCandidate);
    }




}
