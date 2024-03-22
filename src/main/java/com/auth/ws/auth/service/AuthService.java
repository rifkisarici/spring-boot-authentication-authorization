package com.auth.ws.auth.service;

import com.auth.ws.auth.pojo.Credentials;
import com.auth.ws.auth.token.entity.Token;
import com.auth.ws.auth.token.repository.TokenRepository;
import com.auth.ws.configuration.PasswordEncoder;
import com.auth.ws.shared.exceptions.AuthException;
import com.auth.ws.shared.responses.AuthResponse;
import com.auth.ws.user.controller.dto.UserDTO;
import com.auth.ws.user.entity.AppUser;
import com.auth.ws.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;


    public AuthResponse authenticate(Credentials credentials) {
        //hata mesajı farklı olduğu için service kullanılmadı
        Optional<AppUser> userOptional = userRepository.findByUsername(credentials.getUsername());
        if (userOptional.isEmpty()) throw new AuthException();

        AppUser appUser = userOptional.get();

        boolean matches = passwordEncoder.bCryptPasswordEncoder().matches(credentials.getPassword(), appUser.getPassword());
        if (!matches) throw new AuthException();

        UserDTO userDTO = new UserDTO(appUser);
        String token = generateRandomToken();

        Token tokenEntity = new Token(token, appUser);
        tokenRepository.save(tokenEntity);

        AuthResponse response = new AuthResponse();
        response.setUserDTO(userDTO);
        response.setToken(token);
        return response;
    }


    @Transactional(readOnly = true)
    public UserDetails getUserDetails(String token) {
        Optional<Token> tokenOptional = tokenRepository.findById(token);
        if (tokenOptional.isEmpty()) return null;
        return tokenOptional.get().getAppUser();
    }

    public void clearToken(String token) {
        tokenRepository.deleteById(token);
    }

    private String generateRandomToken() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


}
