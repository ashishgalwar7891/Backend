package com.example.usertrack;

import com.example.usertrack.filter.UserMusicFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserTrackApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserTrackApplication.class, args);
    }
@Bean
    public FilterRegistrationBean filterUrl(){
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(new UserMusicFilter());
    filterRegistrationBean.addUrlPatterns("/delete/*","/get");
    return filterRegistrationBean;

}
}
