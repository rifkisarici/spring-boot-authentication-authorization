package com.auth.ws.employer.service;

import com.auth.ws.shared.exceptions.NotFoundException;
import com.auth.ws.shared.responses.GenericResponse;
import com.auth.ws.user.entity.AppUser;
import com.auth.ws.employer.entity.AppEmployer;
import com.auth.ws.employer.repository.EmployerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployerService {
    private final EmployerRepository employerRepository;

    public GenericResponse register(AppEmployer appEmployer) {
        employerRepository.save(appEmployer);
        return new GenericResponse("AppUserEmployer created");
    }

    public AppEmployer getEmployerByAppUser(AppUser appUser){
        Optional<AppEmployer> userOptional = employerRepository.findByAppUser(appUser);
        if (userOptional.isEmpty()) throw new NotFoundException();
        return userOptional.get();
    }


}
