SPRING BOOT, SPRING SECURITY AND THYMELEAF
==========================================

A student asked for a Spring Security version of the Thymeleaf Employee Directory application. This version makes use of in memory Authentication.

For docs on Spring Security and Thymeleaf integration, see this link
- https://www.thymeleaf.org/doc/articles/springsecurity.html


SQL Script
===========
This is the same SQL script used in the course.
- employee.sql: Creates the employee table and loads sample data


MAVEN PROJECT UPDATES
=====================
We need to add entries for Spring Security and Thymeleaf Security

1. Add Spring Security starter

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>


2. Add the Thymeleaf pom entries for Spring Security

		<dependency>
			<groupId>org.thymeleaf.extras</groupId>
			<artifactId>thymeleaf-extras-springsecurity6</artifactId>
		</dependency>



CONFIGURE SPRING SECURITY FOR IN-MEMORY AUTHENTICATION
=====================================================

This project makes use of in-memory authentication. We set up the following users

+---------+----------+-----------------------------+
| user id | password |            roles            |
+---------+----------+-----------------------------+
| john    | test123   | ROLE_EMPLOYEE               |
| mary    | test123   | ROLE_EMPLOYEE, ROLE_MANAGER |
| susan   | test123   | ROLE_EMPLOYEE, ROLE_ADMIN   |
+---------+----------+-----------------------------+

1. The users are defined in the DemoSecurityConfig.java.

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {

		UserDetails john = User.builder()
				.username("john")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();

		UserDetails mary = User.builder()
				.username("mary")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER")
				.build();

		UserDetails susan = User.builder()
				.username("susan")
				.password("{noop}test123")
				.roles("EMPLOYEE", "ADMIN")
				.build();

		return new InMemoryUserDetailsManager(john, mary, susan);
	}



DISPLAY CONTENT BASED ON USER ROLE
==================================

In the application, we want to display content based on user role.

- Employee role: users in this role will only be allowed to list employees.
- Manager role: users in this role will be allowed to list, add and update employees.
- Admin role: users in this role will be allowed to list, add, update and delete employees. 

These restrictions are currently in place with the code: DemoSecurityConfig.java

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


		http.authorizeHttpRequests(configurer ->
						configurer
								.requestMatchers("/").authenticated()
								.requestMatchers("/employees/showForm/**").hasRole("EMPLOYEE")
								.requestMatchers("/employees/save").hasAnyRole("MANAGER", "ADMIN")
								.requestMatchers("/employees/delete").hasRole("ADMIN")
								.requestMatchers("/employees/**").hasRole("EMPLOYEE")
								.requestMatchers("/**").permitAll()
								.requestMatchers("/resources/**").permitAll()
				)
				.formLogin(form ->
						form
								.loginPage("/showMyLoginPage")
								.loginProcessingUrl("/authenticateTheUser")
								.permitAll()
				)
				.logout(logout -> logout.permitAll()
				);

		return http.build();
	}

We also, want to hide/display the links on the view page. For example, if the user has only the "EMPLOYEE" role, then we should only display links available for "EMPLOYEE" role.
Links for "MANAGER" and "ADMIN" role should not be displayed for the "EMPLOYEE".

We can make use of Thymeleaf Security to handle this for us. 


1. Add support for Thymeleaf Security
To use the Thymeleaf Security, we need to add the following to the XML Namespace

File: list-employees.html

<html lang="en" 
		xmlns:th="http://www.thymeleaf.org"
		xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5">

Note the reference for xmlns:sec


2. "Update" button
Only display the "Update" button for users with role of MANAGER OR ADMIN

					<div sec:authorize="hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')">

						<!-- Add "update" button/link -->
						<a th:href="@{/employees/showFormForUpdate(employeeId=${tempEmployee.id})}"
						   class="btn btn-info btn-sm">
							Update
						</a>

					</div>					

3. "Delete" button

Only display the "Delete" button for users with role of ADMIN

					<div sec:authorize="hasRole('ROLE_ADMIN')">  
					
						<!-- Add "delete" button/link -->					
						<a th:href="@{/employees/delete(employeeId=${tempEmployee.id})}"
						   class="btn btn-danger btn-sm"
						   onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">
							Delete
						</a>

					</div>

					

Test the Application
====================
1. Run the Spring Boot application: ThymeleafdemoApplication.java

2. Open a web browser for the app: http://localhost:8080

3. Log in using one of the accounts

+---------+----------+-----------------------------+
| user id | password |            roles            |
+---------+----------+-----------------------------+
| john    | test123  | ROLE_EMPLOYEE               |
| mary    | test123  | ROLE_EMPLOYEE, ROLE_MANAGER |
| susan   | test123  | ROLE_EMPLOYEE, ROLE_ADMIN   |
+---------+----------+-----------------------------+

4. Confirm that you can login and access data based on the roles.


Congratulations! You have an app that uses Spring Boot, Spring Security, Thymeleaf, Spring Data JPA
 					