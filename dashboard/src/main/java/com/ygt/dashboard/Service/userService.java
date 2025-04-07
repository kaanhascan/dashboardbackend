package com.ygt.dashboard.Service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ygt.dashboard.DTO.LoginRequest;
import com.ygt.dashboard.Model.User;
import com.ygt.dashboard.Repository.userRepository;

import jakarta.persistence.EntityManager;

@Service
public class userService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private userRepository userRepository;

    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOpt = userRepository.findByUsernameAndPassword(
            loginRequest.getUsername(), loginRequest.getPassword()
        );

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return ResponseEntity.ok().body(Map.of(
                "message", "Login successful",
                "userId", user.getId(),
                "schema", "user" + user.getId() 
            ));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", "Invalid credentials"));
        }
    }

    public void setSchema(String schema) {
        entityManager.createNativeQuery("SET search_path TO " + schema).executeUpdate();
    }
}
