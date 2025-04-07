package com.ygt.dashboard;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ygt.dashboard.Repository.userRepository;

@SpringBootApplication
public class DashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
	}

	//Bağlantı testi yaptım
    @Bean
    public CommandLineRunner testConnection(userRepository userRepository) {
        return args -> {
            if(userRepository.count() > 1){
                System.out.println("Bağlant Başarılı");
            }
            else{
                System.out.println("Bağlantı Başarısız");
            }
        };
    }
}



