package com.student.web.controller;

import com.student.web.entity.Student;
import com.student.web.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping({"/Students", "/"})
    public String studentsList(Model model) {
        model.addAttribute("students", studentService.listOfStudents());
        return "Students"; //Send us to Students file
    }

    @GetMapping("/Student/new")
    public String createStudent (Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create-student";
    }

    @PostMapping("/Students")
    public String saveStudents (@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/Students";
    }

    @GetMapping("/Students/edit/{id}")
    public String updateStudentForm (@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit-student";
    }

    @PostMapping("/Students/{id}")
    public String updateStudent (@PathVariable Long id, @ModelAttribute("student") Student student, Model model){
        Student currStudent = studentService.getStudentById(id);
        currStudent.setId(id);
        currStudent.setFirstName(student.getFirstName());
        currStudent.setLastName(student.getLastName());
        currStudent.setEmail(student.getEmail());

        studentService.updateStudent(currStudent);
        return "redirect:/Students";
    }

    @GetMapping("/Students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/Students";
    }
}
