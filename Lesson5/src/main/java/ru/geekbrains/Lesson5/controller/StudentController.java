package ru.geekbrains.Lesson5.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.Lesson5.entity.Student;
import ru.geekbrains.Lesson5.repository.StudentRepository;
import ru.geekbrains.Lesson5.service.StudentService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {

    StudentService studentService;
    StudentRepository studentRepository;

    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }


    @RequestMapping(value = "/students/create", method = RequestMethod.GET)
    public List<Student> createSomeStudents() {
        studentService.createSomeStudents();
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable(value = "id") int id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found Student with id = " + id));
        return student;
    }

    @RequestMapping(value = "/students/delete/{id}", method = RequestMethod.GET)
    public List<Student> deleteStudentById(@PathVariable(value = "id") int id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found Student with id = " + id));
        if (student != null) {
            studentRepository.delete(student);
        }
        return studentRepository.findAll();
    }

}
