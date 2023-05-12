package com.utsav.cruddemo;

import com.utsav.cruddemo.DAO.StudentDAO;
import com.utsav.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			//create one student object
			//createStudent(studentDAO);

			//create multiple student object
			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//update a student data
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);
		Student muStudent = studentDAO.findById(studentId);

		// change first name to "Deep"
		System.out.println("Updating student ...");
		muStudent.setFirstName("Deep");

		// update the student
		studentDAO.update(muStudent);

		// display the updated student
		System.out.println("Updated student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Katharotiya");

		// display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student objects...");
		Student tempStudent = new Student("utsav","Katharotiya","utsav@gmail.com");

		// save the student
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: "+ theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: "+myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 new students object....");
		Student tempStudent1 = new Student("utsav","Katharotiya","utsav@gmail.com");
		Student tempStudent2 = new Student("deep","patel","deep@gmail.com");
		Student tempStudent3 = new Student("jainam","jain","jainam@gmail.com");

		//save the students objects
		System.out.println("Saving the studentss....");
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
