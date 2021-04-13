package ru.geekbrains.spring.context;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InMemoryStudentRepository implements StudentRepository {
    private List<Student> students;

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @PostConstruct
    public void init() {
        students = new ArrayList<>(Arrays.asList(
                new Student(1L, "Bob", 80),
                new Student(2L, "Jack", 90),
                new Student(3L, "John", 85)
        ));
    }
}
