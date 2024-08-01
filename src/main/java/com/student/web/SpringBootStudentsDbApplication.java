package com.student.web;

import com.student.web.entity.Student;
import com.student.web.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStudentsDbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudentsDbApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		Student student1 = new Student("Abdel Salam", "Shehadeh", "Abdel_shehadeh@hotmail.com");
		studentRepository.save(student1);

		Student student2 = new Student("Anakin", "Skywalker", "Anakin_Skywalker@hotmail.com");
		studentRepository.save(student2);
		*/
	}
}
