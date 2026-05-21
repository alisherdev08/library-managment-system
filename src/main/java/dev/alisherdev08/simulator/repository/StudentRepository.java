package dev.alisherdev08.simulator.repository;

import dev.alisherdev08.simulator.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void save(Student student){
        students.add(student);
    }
    public List<Student> findAll(){
         return students;
    }
    public Student findById(UUID id){
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }
    public void deleteById(UUID id){
        students.removeIf(student -> student.getId().equals(id));
    }
    public List<Student> searchByName(String studentName){
        return students.stream().filter(student -> student.getFullName().equals(studentName)).toList();
    }













}
