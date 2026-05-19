package dev.alisherdev08.simulator.repository;

import dev.alisherdev08.simulator.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void add(Student student){
        students.add(student);
    }
    public List<Student> findAll(){
         return students;
    }
    public Student findByID(UUID id){
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }
    public void deleteByID(UUID id){
        students.removeIf(student -> student.getId().equals(id));
    }















}
