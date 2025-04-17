package com.ygt.dashboard.Controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ygt.dashboard.Model.Support;
import com.ygt.dashboard.Repository.SupportRepository;
import com.ygt.dashboard.Service.JavaMailService;

@RequestMapping("/api/support")
@Controller
@CrossOrigin(origins = "*")
public class SupportController {
    
    private final SupportRepository supportRepository;
    private final JavaMailService javaMailService;

    public SupportController(SupportRepository supportRepository, JavaMailService javaMailService) {
        this.supportRepository = supportRepository;
        this.javaMailService = javaMailService;
    }

    @PostMapping("/message")
    public ResponseEntity<String> receiveSupportMessage(@RequestBody Support message ,@RequestHeader(value = "X-Schema" , required = false) String schema) { 
        if (message.getName() == null || message.getEmail() == null || message.getSubject() == null || message.getMessage() == null) {
            return ResponseEntity.badRequest().body("Lütfen tüm alanları doldurun.");
        } 
        if (schema != null && schema.startsWith("user")) {
            try {
                Long userId = Long.parseLong(schema.replace("user", ""));
                message.setUserId(userId);
            } catch (NumberFormatException e) {
                System.err.println("Invalid User");
            }
        }

        supportRepository.save(message);               
        javaMailService.sendSupportEmail(message);         
        return ResponseEntity.ok("Mesajınız başarıyla alındı ve iletildi.");
    }
    

}
