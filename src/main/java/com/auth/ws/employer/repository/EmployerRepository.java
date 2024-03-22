package com.auth.ws.employer.repository;


import com.auth.ws.employer.entity.AppEmployer;
import com.auth.ws.user.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployerRepository extends JpaRepository<AppEmployer, Long> {
    Optional<AppEmployer> findByAppUser(AppUser appUser);
}
