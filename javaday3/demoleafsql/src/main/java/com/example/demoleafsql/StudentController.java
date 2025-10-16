package com.example.demoleafsql.controller;

import com.example.demoleafsql.entity.Student;
import com.example.demoleafsql.repository.StudentRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // List students
    @GetMapping("/list")
    public String listStudents(HttpSession session, Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("title", "Sri Eshwar College of Engineering - Student List");
        return "list";
    }

    // Show form for new student
    @GetMapping("/form")
    public String showForm(Student student) {
        return "form";
    }

    // Save student (new or update)
    @PostMapping("/form")
    public String saveStudent(Student student) {
        studentRepository.save(student);
        return "redirect:/students/list";
    }

    // Edit student
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        return "form";
    }

    // Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        studentRepository.delete(student);
        return "redirect:/students/list";
    }
}
