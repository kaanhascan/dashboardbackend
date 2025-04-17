package com.ygt.dashboard.Controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<String> receiveSupportMessage(@RequestBody Support message) {  
        supportRepository.save(message);               
        javaMailService.sendSupportEmail(message);         
        return ResponseEntity.ok("Mesajınız başarıyla alındı ve iletildi.");
    }
    

}
