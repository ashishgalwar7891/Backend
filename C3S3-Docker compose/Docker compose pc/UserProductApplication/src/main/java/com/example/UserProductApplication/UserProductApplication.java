package com.example.UserProductApplication;

import com.example.UserProductApplication.filter.UserProductFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProductApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<?> filterUrl(){
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new UserProductFilter());
		filterRegistrationBean.addUrlPatterns("/product/getUser");
		filterRegistrationBean.addUrlPatterns("/product/delete/*");
		return filterRegistrationBean;
	}
}
