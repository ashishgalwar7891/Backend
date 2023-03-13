package com.example.springBoot_JWT_CustomerApp;

import com.example.springBoot_JWT_CustomerApp.filter.CustomerAddressFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJwtCustomerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtCustomerAppApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<?> filterUrl(){
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new CustomerAddressFilter());
		filterRegistrationBean.addUrlPatterns("/customer/");
		filterRegistrationBean.addUrlPatterns("/customer/delete/*");
		return filterRegistrationBean;
	}

}
