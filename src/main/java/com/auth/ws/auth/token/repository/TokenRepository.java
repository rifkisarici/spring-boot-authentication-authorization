package com.auth.ws.auth.token.repository;

import com.auth.ws.auth.token.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, String> {
}
