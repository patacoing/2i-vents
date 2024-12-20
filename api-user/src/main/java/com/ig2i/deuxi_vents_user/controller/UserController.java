package com.ig2i.deuxi_vents_user.controller;


import com.ig2i.deuxi_vents_user.dto.UserDto;
import com.ig2i.deuxi_vents_user.entity.User;
import com.ig2i.deuxi_vents_user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<UserDto> getAllUsers() {
        List<UserDto> users = userService.findAll();

        return users;
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable String id) {
        User user = userService.findUserById(id);
        return new UserDto(
                user.getId(), user.getFirstName(), user.getLastName(), user.getPromo(), user.getPassword(), user.getRole().name()
        );
    }


    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable String id,
                              @RequestBody UserDto userDto) {
        System.out.println(userDto);
        return userDto;
    }
}
