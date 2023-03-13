package org.example.appMain;

import org.example.config.Empconfig;
import org.example.domain.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class constructorAutowiring {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(Empconfig.class);
        Employee e=(Employee) context.getBean("emp1");
        System.out.println(e);
    }
}
