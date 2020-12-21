package employee.demo.pojo;

import java.time.LocalDate;

public class Employee {
    String empId;
    String empName;
    String empGender;
    LocalDate empBirth;
    Department department;

    public Employee() {
    }

    public Employee(String empId, String empName, String empGender, LocalDate empBirth, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.empGender = empGender;
        this.empBirth = empBirth;
        this.department = department;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public LocalDate getEmpBirth() {
        return empBirth;
    }

    public void setEmpBirth(LocalDate empBirth) {
        this.empBirth = empBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empGender='" + empGender + '\'' +
                ", empBirth=" + empBirth +
                ", department=" + department +
                '}';
    }
}
