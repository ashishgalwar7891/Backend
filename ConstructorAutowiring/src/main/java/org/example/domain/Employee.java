package org.example.domain;


import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
    int empId;
    String empName;
    Department dept;
    @Autowired
    public Employee(Department dept) {
        this.dept = dept;
    }

    public Employee(int empId, String empName, Department dept) {
        this.empId = empId;
        this.empName = empName;
        this.dept = dept;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", dept=" + dept +
                '}';
    }
}
