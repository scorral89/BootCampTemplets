package com.st.studentProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.studentProject.model.Student;
import com.st.studentProject.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public Student findStudent(Long id)
	{
		return studentRepository.findStudentById(id);
	}
	public List<Student> findAll()
	{
		return studentRepository.findAll();
	}
}
