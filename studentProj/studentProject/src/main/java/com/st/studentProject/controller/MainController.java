package com.st.studentProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.studentProject.model.Student;
import com.st.studentProject.service.StudentService;

@Controller
public class MainController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	@ResponseBody
	public String index()
	{ 
		
		return "<h1>Student Project</h1>";
	}

	@GetMapping("/students")
	public String allStudents(Model model)
	{ 
		List<Student> allStudents = studentService.findAll();
		
		model.addAttribute("students", allStudents);
		
		return "students";
	}
	@GetMapping("/student/{id}")
	@ResponseBody
	public Student studentById(@PathVariable Long id)
	{ 
		return studentService.findStudent(id);
	}
}
