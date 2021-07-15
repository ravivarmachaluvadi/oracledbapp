package com.connect.oracledbapp;

import com.connect.oracledbapp.entity.Employee;
import com.connect.oracledbapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@SpringBootApplication
public class OracledbappApplication implements CommandLineRunner {

	@Autowired
	EntityManager entityManager;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(OracledbappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Employee sking = employeeRepository.findByEmail("SKING");

		List<Employee> byFirstnameLike = employeeRepository.findByFirstnameLike("Ra%");

		List<Employee> byManagerIdIsNull = employeeRepository.findByManagerIdIsNull();

		/*List<Employee> employeeNative = employeeRepository.getEmployeeNative();

		employeeNative.stream().forEach(employee -> System.out.println(employee));*/

	/*	for (int i = 0; i < 500; i++) {

			System.out.println("EntityManager entityManager"+i +"= entityManagerFactory.createEntityManager();");
			System.out.println("System.out.println(\"Got connection :  \""+i+");");

		}*/

		/*EntityManager entityManager0= entityManagerFactory.createEntityManager();

		entityManagerFactory.createEntityManager();

		entityManagerFactory.close();*/



		/*Query query = entityManager.createNativeQuery("select e.first_name,d.department_name from employees e,departments d where e.department_id = d.department_id");
		List<Object[]> resultList= query.getResultList();
		resultList.stream().forEach(objects -> System.out.println(" first_name "+objects[0]+" , department_name "+objects[1]));

		Query query1 = entityManager.createNativeQuery("select e.first_name,d.department_name from employees e,departments d where e.department_id = d.department_id");
		List<Object[]> resultList1= query1.getResultList();
		resultList1.stream().forEach(objects -> System.out.println(" first_name "+objects[0]+" , department_name "+objects[1]));
*/


	}
}
