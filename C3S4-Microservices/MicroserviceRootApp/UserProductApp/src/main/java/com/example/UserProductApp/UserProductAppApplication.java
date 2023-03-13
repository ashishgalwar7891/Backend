package com.example.UserProductApp;

import com.example.UserProductApp.filter.UserProductFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProductAppApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterUrl()
	{
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new UserProductFilter());
		filterRegistrationBean.addUrlPatterns("/product/getUsers");

		return filterRegistrationBean;
	}

}
