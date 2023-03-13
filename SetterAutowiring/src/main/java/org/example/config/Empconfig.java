package org.example.config;

import org.example.domain.Address;
import org.example.domain.Employee;
import org.springframework.context.annotation.Bean;

public class Empconfig {
    @Bean("emp1")
    public Employee getEmployee(){
        Employee e1=new Employee();
        e1.setEmpId(101);
        e1.setEmpName("anup");
//        e1.setAddress(getEmployee());
        return e1;
    }
    @Bean
    public Address getAddress(){
        return new Address(12,"bbb","alwar");
    }
}
