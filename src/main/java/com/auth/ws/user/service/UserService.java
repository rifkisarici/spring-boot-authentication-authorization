package com.auth.ws.user.service;


import com.auth.ws.shared.exceptions.NotFoundException;
import com.auth.ws.user.entity.AppUser;
import com.auth.ws.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;


    public AppUser register(AppUser appUser) {
        appUser.setPassword(this.passwordEncoder.encode(appUser.getPassword()));
        userRepository.save(appUser);
        return appUser;
    }

    public Page<AppUser> getUserAll(Pageable page, AppUser appUser) {
        //Pageable page= PageRequest.of(0,5);
        if (appUser != null)
            return userRepository.findByUsernameNot(appUser.getUsername(), page);
        return userRepository.findAll(page);
    }


    @Transactional
    public AppUser getUserByUsername(String username) {
        Optional<AppUser> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) throw new NotFoundException();
        return userOptional.get();
    }


    /*public AppUser updateUser( UserUpdateRegistration updatedUser, AppUser appUser) {
        //TODO: CurrentUser ile güncellenecek User'ın username'ini kıyaslyabiliriz.

        if (!appUser.getUsername().equals(updatedUser.getUsername())) throw new IllegalArgumentException("napıyon amk");
        appUser.setSurname(updatedUser.getSurname());
        return userRepository.save(appUser);
    }
*/


}
