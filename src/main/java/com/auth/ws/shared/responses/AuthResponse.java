package com.auth.ws.shared.responses;

import com.auth.ws.user.controller.dto.UserDTO;
import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private UserDTO userDTO;
}
