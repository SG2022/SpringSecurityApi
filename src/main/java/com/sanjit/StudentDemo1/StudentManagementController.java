package com.sanjit.StudentDemo1;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

	private static final List<Student> STUDENTS = Arrays.asList(new Student(1, "James Bond"),
			new Student(2, "Maria jones"), new Student(3, "AnnaSmith"));

	@GetMapping
	public List<Student> getAllStudents() {
		System.out.println("get all students");
		return STUDENTS;
	}

	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		System.out.println("registered Students");
		System.out.println(student);
	}

	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("Student deleted "+ studentId);
		System.out.println(studentId);
	}

	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable("studetId") Integer studentId, @RequestBody Student student)

	{
		System.out.println("Students updated with id "+ studentId);
		System.out.println(String.format("%s %s", studentId, student));
	}

}
