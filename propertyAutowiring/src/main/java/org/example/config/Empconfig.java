package org.example.config;

import org.example.domain.Address;
import org.example.domain.Employee;
import org.springframework.context.annotation.Bean;

public class Empconfig {
    @Bean("emp1")
    public Employee getemp(){
        Employee e1=new Employee();
        e1.setEmpId(101);
        e1.setEmpName("john");
        e1.setAddress(getAddress());
        return e1;
    }
    @Bean
    public Address getAddress() {
        return new Address(11,"aaa","jaipur");
    }
}
