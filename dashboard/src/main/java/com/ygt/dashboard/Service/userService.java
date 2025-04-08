package com.ygt.dashboard.Service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ygt.dashboard.DTO.LoginRequest;
import com.ygt.dashboard.Model.User;
import com.ygt.dashboard.Repository.UserRepository;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        Optional<User> userOpt = userRepository.findByUsernameAndPassword(
            loginRequest.getUsername(), loginRequest.getPassword()
        );

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            String schema = "user" + user.getId();
            
            return ResponseEntity.ok().body(Map.of(
                "message", "Login successful",
                "userId", user.getId(),
                "schema", schema
            ));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", "Invalid credentials"));
        }
    }
}
