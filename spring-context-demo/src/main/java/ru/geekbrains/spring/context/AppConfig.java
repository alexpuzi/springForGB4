package ru.geekbrains.spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("ru.geekbrains.spring.context")
public class AppConfig {
    @Bean
    public Connection connection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Невозможно подключиться к БД");
        }
    }
}
