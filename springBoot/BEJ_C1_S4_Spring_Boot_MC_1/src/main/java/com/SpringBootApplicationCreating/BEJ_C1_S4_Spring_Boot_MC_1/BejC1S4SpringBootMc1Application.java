package com.SpringBootApplicationCreating.BEJ_C1_S4_Spring_Boot_MC_1;

import com.SpringBootApplicationCreating.BEJ_C1_S4_Spring_Boot_MC_1.Services.MessageServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BejC1S4SpringBootMc1Application {

	public static void main(String[] args) {
		MessageServices msg;
		ApplicationContext context= SpringApplication.run(BejC1S4SpringBootMc1Application.class, args);
		msg= context.getBean("messageServices", MessageServices.class);
		String message=msg.mathod1();
		System.out.println(message);
		System.out.println("Good Day to all from Main class!!!");
	}

}
