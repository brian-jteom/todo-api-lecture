package com.example.todo_api_lecture.service;

import com.example.todo_api_lecture.dto.RegisterRequest;
import com.example.todo_api_lecture.entity.TbUser;
import com.example.todo_api_lecture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TbUser registerNewUser(RegisterRequest registerRequest) {
        TbUser user = new TbUser();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setEnabled(true);
        user.setAuthority(registerRequest.getAuthority());

        return userRepository.save(user);
    }
}
