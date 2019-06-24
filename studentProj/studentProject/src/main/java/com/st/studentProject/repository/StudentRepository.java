package com.st.studentProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.st.studentProject.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
	public List<Student> findAll();
	public Student findStudentById(Long id);
	}
