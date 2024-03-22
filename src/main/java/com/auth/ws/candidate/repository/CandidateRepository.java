package com.auth.ws.candidate.repository;


import com.auth.ws.candidate.entity.AppCandidate;
import com.auth.ws.user.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CandidateRepository extends JpaRepository<AppCandidate, Long> {
    Optional<AppCandidate> findByAppUser(AppUser appUser);
}
