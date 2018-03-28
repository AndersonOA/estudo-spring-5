package br.com.makersweb.oauth.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class OAuthSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthSecurityApplication.class, args);
	}
}
