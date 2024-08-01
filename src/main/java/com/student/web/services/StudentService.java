package com.student.web.services;

import com.student.web.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> listOfStudents();

    public Student saveStudent(Student student);

    public  Student getStudentById(Long id);

    public Student updateStudent(Student student);

    public  void deleteStudent(Long id);
}
