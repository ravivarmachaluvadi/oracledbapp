package com.connect.oracledbapp.repository;

import com.connect.oracledbapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

    //@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
    Employee findByEmployeeId(int i);

    //FETCH NEXT 10 ROWS ONLY
    @Query(
            value = "select * from employees where last_name='Chaluvadi' FETCH NEXT 1 ROWS ONLY",
            nativeQuery = true)
    List<Employee> findEmployees();

    @Query(value = "select e.* from employees e,departments d where e.department_id = d.department_id and d.department_name='Administration'",nativeQuery = true)
    List<Employee>  getEmployeeNative();

    List<Employee>  findByManagerIdIsNull();

    List<Employee> findByFirstnameLike(String s);

    @Query("select e from Employee e where e.email = ?1")
    Employee findByEmail(String email);

    Collection<NamesOnly> findByLastname(String lastName);

    NamesOnly findTopByLastname(String lastName);




}
