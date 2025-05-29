package com.ygt.dashboard.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ygt.dashboard.Config.PasswordUtil;
import com.ygt.dashboard.Repository.UserRepository;


import com.ygt.dashboard.DTO.LoginRequest;
import com.ygt.dashboard.Model.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

   @Test
    void testLogin() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testUser");
        user.setPassword(PasswordUtil.hashPassword("testPass")); 

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("testUser");
        loginRequest.setPassword("testPass");

        when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(user));

        ResponseEntity<?> response = userService.login(loginRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testLogin_UserNotFound() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("nonExistentUser");
        loginRequest.setPassword("testPass");

        ResponseEntity<?> response = userService.login(loginRequest);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    @Test
    void testLogin_WrongPassword() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testUser");
        user.setPassword(PasswordUtil.hashPassword("correctPass"));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("testUser");
        loginRequest.setPassword("wrongPass");

        when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(user));

        ResponseEntity<?> response = userService.login(loginRequest);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }
}
