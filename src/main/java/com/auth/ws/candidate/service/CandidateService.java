package com.auth.ws.candidate.service;

import com.auth.ws.shared.exceptions.NotFoundException;
import com.auth.ws.shared.responses.GenericResponse;
import com.auth.ws.candidate.entity.AppCandidate;
import com.auth.ws.candidate.repository.CandidateRepository;
import com.auth.ws.user.entity.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public GenericResponse register(AppCandidate appCandidate) {
        candidateRepository.save(appCandidate);
        return new GenericResponse("AppUserCandidate created");
    }

    public GenericResponse saveAbout(AppCandidate appCandidate, String about) {
        appCandidate.setAbout(about);
        candidateRepository.save(appCandidate);
        return new GenericResponse("candidate about created");
    }

    @Transactional
    public AppCandidate getCandidateByAppUser(AppUser appUser) {
        Optional<AppCandidate> userOptional = candidateRepository.findByAppUser(appUser);
        if (userOptional.isEmpty()) throw new NotFoundException();
        return userOptional.get();
    }

    public String getAbout(AppCandidate appCandidate) {
        return appCandidate.getAbout();
    }
}
