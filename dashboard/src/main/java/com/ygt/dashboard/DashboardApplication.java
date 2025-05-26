package com.ygt.dashboard;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ygt.dashboard.Repository.UserRepository;

import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class DashboardApplication {

	public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
                .directory("./") 
                .filename(".env") 
                .load();

        System.setProperty("MAIL_USERNAME", dotenv.get("MAIL_USERNAME"));
        System.setProperty("MAIL_PASSWORD", dotenv.get("MAIL_PASSWORD"));

		SpringApplication.run(DashboardApplication.class, args);
	}

	//Bağlantı testi yaptım
    @Bean
    public CommandLineRunner testConnection(UserRepository userRepository) {
        return args -> {
            if(userRepository.count() >= 1){
                System.out.println("Bağlantı Başarılı");
            }
            else{
                System.out.println("Bağlantı Başarısız");
            }
        };
    }
}



