package com.auth.ws.auth.controller;

import com.auth.ws.auth.pojo.Credentials;
import com.auth.ws.auth.service.AuthService;
import com.auth.ws.shared.responses.AuthResponse;
import com.auth.ws.shared.responses.GenericResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/1.0")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public AuthResponse handleAuthentication(@RequestBody Credentials credentials) {
        return authService.authenticate(credentials);
    }


    @PostMapping("/logout")
    public GenericResponse handleLogout(@RequestHeader(name = "Authorization") String authorization) {
        String token = authorization.substring(7);
        authService.clearToken(token);
        return new GenericResponse("Logout success");
    }
}
