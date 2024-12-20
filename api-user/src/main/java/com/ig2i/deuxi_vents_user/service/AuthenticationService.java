package com.ig2i.deuxi_vents_user.service;

import com.ig2i.deuxi_vents_user.dto.LoginDto;
import com.ig2i.deuxi_vents_user.dto.RegisterDto;
import com.ig2i.deuxi_vents_user.entity.User;
import com.ig2i.deuxi_vents_user.entity.enums.UserRole;
import com.ig2i.deuxi_vents_user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterDto input) {
        User user = new User(input.getFirstName(), input.getLastName(), input.getPromo(), passwordEncoder.encode(input.getPassword()));

        user.setRole(UserRole.PARTICIPANT);

        return userRepository.save(user);
    }

    public User authenticate(LoginDto input) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        input.getFirstname() + " " + input.getLastname(),
//                        input.getPassword()
//                )
//        );
        System.out.println("authenticate(");

        return userRepository.findUserByFirstNameAndLastName(input.getFirstname(), input.getLastname());
    }

}
