package com.connect.oracledbapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EMPLOYEES",schema = "HR")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    @Column(name = "FIRST_NAME")
    private String firstname;

    @Column(name = "LAST_NAME")
    private String lastname;
    @Column(name = "EMAIL")
    private String  email;
    private String PHONE_NUMBER;
    private Date HIRE_DATE;
    private String JOB_ID;
    @Column(name = "SALARY")
    private Float salary;
    private Float COMMISSION_PCT;
    @Column(name = "MANAGER_ID")
    private Integer managerId;
    private  Integer DEPARTMENT_ID;
    //private  Integer DEPT_ID; new field with "hibernate.hbm2ddl.auto", "none" will give invalid identifier exception
    ////private  Integer DEPT_ID; new field with "hibernate.hbm2ddl.auto", "anyother"  will alter db table add new column to table
}
