package ru.geekbrains.spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(@Qualifier("dbStudentRepository") StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public int getAverageScore() {
        int avg = 0;
        List<Student> students = studentRepository.getStudents();
        for (Student s : students) {
            avg += s.getScore();
        }
        avg /= students.size();
        return avg;
    }
}
