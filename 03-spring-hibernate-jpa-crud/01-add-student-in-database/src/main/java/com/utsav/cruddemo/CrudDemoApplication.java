package com.utsav.cruddemo;

import com.utsav.cruddemo.DAO.StudentDAO;
import com.utsav.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	// From the Spring Boot Framework
	// Executed after the Spring Beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		// Use java lambda expression
		return runner -> {
			// create one student object
			//createStudent(studentDAO);
			
			//create multiple student object
			createMultipleStudents(studentDAO);
			
		};
	}
	
	private void createMultipleStudents(StudentDAO studentDAO) {
		
		//create multiple students
		System.out.println("Creating 3 new student objects....");
		Student tempStudent1 = new Student("utsav","Katharotiya","utsav@gmail.com");
		Student tempStudent2 = new Student("deep","patel","deep@gmail.com");
		Student tempStudent3 = new Student("jainam","jain","jainam@gmail.com");
		
		// save the student objects
		System.out.println("Saving the students....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}


	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object....");
		Student tempStudent = new Student("utsav","Katharotiya","utsav@gmail.com");

		// save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}
}
