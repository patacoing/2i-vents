package com.ig2i.deuxi_vents_user.controller;

import com.ig2i.deuxi_vents_user.dto.AuthResponseDto;
import com.ig2i.deuxi_vents_user.dto.LoginDto;
import com.ig2i.deuxi_vents_user.dto.RegisterDto;
import com.ig2i.deuxi_vents_user.entity.User;
import com.ig2i.deuxi_vents_user.service.AuthenticationService;
import com.ig2i.deuxi_vents_user.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }


    @PostMapping("signup")
    public ResponseEntity<User> register(@RequestBody RegisterDto registerDto) {
        User registeredUser = authenticationService.signup(registerDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        User authenticatedUser = authenticationService.authenticate(loginDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        AuthResponseDto loginResponse = new AuthResponseDto(jwtToken, jwtToken, authenticatedUser.getId());

        return ResponseEntity.ok(loginResponse);
    }
}
