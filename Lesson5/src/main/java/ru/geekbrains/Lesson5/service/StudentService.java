package ru.geekbrains.Lesson5.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.Lesson5.entity.Student;
import ru.geekbrains.Lesson5.repository.StudentRepository;

@Service
public class StudentService {

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private StudentRepository studentRepository;

    public void createSomeStudents() {
        for (int i = 0; i < 10; i++) {
            studentRepository.save(new Student("Student" + i, 1 + Math.random() * 5));
        }
    }
}
