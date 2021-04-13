package ru.geekbrains.spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbStudentRepository implements StudentRepository {
    private Connection connection;

    @Autowired
    public DbStudentRepository(Connection connection) {
        this.connection = connection;
    }

    @PostConstruct
    public void init() {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("drop table if exists students;");
            stmt.executeUpdate("create table if not exists students (id integer primary  key, name text, score integer);");
            stmt.executeUpdate("insert into students (id, name, score) values (1, 'Jack', 100);");
            stmt.executeUpdate("insert into students (id, name, score) values (2, 'John', 80);");
            stmt.executeUpdate("insert into students (id, name, score) values (3, 'Bob', 85);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            try (ResultSet rs = stmt.executeQuery("select * from students;")) {
                while (rs.next()) {
                    Student s = new Student(rs.getLong(1), rs.getString(2), rs.getInt(3));
                    students.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
