package com.st.studentProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@DeleteMapping("/students")
	public void deleteAll()
	{
	 studentService.deleteAll();
	}
	@DeleteMapping("/student/{id}")
	public void deleteStudentId(@PathVariable Long id)
	{
		studentService.deleteStudentById(id);
	}
	@PostMapping("/student/new/")
	@ResponseBody
	public void saveStudent(@PathVariable Student student)
	{
		studentService.saveStudent(student);
	}
	@PutMapping("/student/new/{test}")
	@ResponseBody
	public void updateStudent(Long id, Student updateStudent)
	{
		studentService.updateStudent(id, updateStudent);
	}
}
