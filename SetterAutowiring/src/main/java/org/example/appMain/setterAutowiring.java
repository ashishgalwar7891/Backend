package org.example.appMain;

import org.example.config.Empconfig;
import org.example.domain.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class setterAutowiring {
    public static void main(String[] args) {
        ApplicationContext con=new AnnotationConfigApplicationContext(Empconfig.class);
        Employee e= con.getBean("emp1", Employee.class);
        System.out.println(e);
    }
}
