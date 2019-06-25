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
	public void deleteAll()
	{
		studentRepository.deleteAll();
	}
	public void deleteStudentById(Long id)
	{
		studentRepository.deleteById(id);
	}
	public void saveStudent(Student student)
	{
		studentRepository.save(student);
	}
	public void updateStudent(Long id, Student updateStudent)
	{
		Student studentReplace = studentRepository.findStudentById(id);
		String firstName= updateStudent.getFirstName();
		String lastName= updateStudent.getLastName();
		String adjName= updateStudent.getAdjName();
		if(firstName != null) studentReplace.setFirstName(firstName);
		if(lastName != null) studentReplace.setLastName(lastName);
		if(adjName != null) studentReplace.setAdjName(adjName);
		
	}
}
