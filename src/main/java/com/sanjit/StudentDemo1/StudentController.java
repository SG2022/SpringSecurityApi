package com.sanjit.StudentDemo1;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	private static final List<Student> STUDENTS = Arrays.asList(new Student(1, "James Bond"),
			new Student(2, "Maria jones"), new Student(3, "AnnaSmith"));

	@GetMapping(path = "{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer studentId) {
		return STUDENTS.stream().filter(student -> student.getStudentId().equals(studentId)).findFirst()
				.orElseThrow(() -> new IllegalStateException("Student " + studentId + "does not exists"));
	}

}
