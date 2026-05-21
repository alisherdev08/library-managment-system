package dev.alisherdev08.simulator.service;

import dev.alisherdev08.simulator.entity.Student;
import dev.alisherdev08.simulator.repository.StudentRepository;

import java.util.List;
import java.util.UUID;

public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void addStudent(String fullName){
        Student student = new Student(UUID.randomUUID(), fullName);
        studentRepository.save(student);
    }
    public void removeStudent(UUID studentId){
       Student student = studentRepository.findById(studentId);
       if(student != null){
           studentRepository.deleteById(studentId);
           System.out.println("Student removed: " + student.getId());
       } else {
           System.out.println("Student not found: " + studentId);
       }
    }
    public void updateStudent(UUID studentId, String newFullName){
        Student student = studentRepository.findById(studentId);
        if(student != null){
            student.setFullName(newFullName);
            System.out.println("Student updated: " + studentId);
        } else {
            System.out.println("Student not found: " + studentId);
        }
    }
    public Student findStudentById(UUID studentId){
        return  studentRepository.findById(studentId);
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }








}
