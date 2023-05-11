package com.utsav.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Explicitly list base packages(in util directory) to scan
@SpringBootApplication(
		scanBasePackages={"com.utsav.springcore","com.utsav.util"})
// @SpringBootApplication is used when all components in our springcore directory
//@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreApplication.class, args);
	}

}
