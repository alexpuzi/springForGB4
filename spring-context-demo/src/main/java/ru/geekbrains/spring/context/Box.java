package ru.geekbrains.spring.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Box {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Box() {
        this.color = "Red";
    }
}
