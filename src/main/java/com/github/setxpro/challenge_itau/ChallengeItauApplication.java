package com.github.setxpro.challenge_itau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ChallengeItauApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeItauApplication.class, args);
	}

}
