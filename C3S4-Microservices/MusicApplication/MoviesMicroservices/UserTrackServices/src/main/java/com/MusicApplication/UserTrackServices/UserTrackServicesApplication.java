package com.MusicApplication.UserTrackServices;

import com.MusicApplication.UserTrackServices.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserTrackServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserTrackServicesApplication.class, args);
	}

}
