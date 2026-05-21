package dev.alisherdev08.simulator.entity;

import java.util.UUID;

public class Student {
    private UUID id;
    private String fullName;

    public Student(UUID id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + fullName + '\'' +
                '}';
    }
}