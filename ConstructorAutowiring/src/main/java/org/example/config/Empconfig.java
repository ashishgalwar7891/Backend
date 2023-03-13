package org.example.config;

import org.example.domain.Department;
import org.example.domain.Employee;
import org.springframework.context.annotation.Bean;

public class Empconfig {
    @Bean("emp1")
    public Employee getemp(){
        Employee e1=new Employee(getdept());
        e1.setEmpId(103);
        e1.setEmpName("ashish");
        return e1;
    }

    public Department getdept(){
        return new Department(5,"finance");
    }
}
