package com.example.c2.s3.mc1;

import com.example.c2.s3.mc1.filter.Userfilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public FilterRegistrationBean filterUrl()
	{
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new Userfilter());
		filterRegistrationBean.addUrlPatterns("/api/v1/get");
		filterRegistrationBean.addUrlPatterns("/api/v1/delete/*");
		filterRegistrationBean.addUrlPatterns("/api/v1/rating");
		return filterRegistrationBean;
	}

}
