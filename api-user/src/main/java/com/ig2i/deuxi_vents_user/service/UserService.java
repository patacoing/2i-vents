package com.ig2i.deuxi_vents_user.service;

import com.ig2i.deuxi_vents_user.dto.UserDto;
import com.ig2i.deuxi_vents_user.entity.User;
import com.ig2i.deuxi_vents_user.mapper.UserMapper;
import com.ig2i.deuxi_vents_user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();

        return users.stream().map(userMapper::fromUser).collect(Collectors.toList());
    }

    public User findUserById(String userId) {
        User user = userRepository.findUserById(userId);

        System.out.println(user);

        return user;
    }
}
