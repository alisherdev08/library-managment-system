package dev.alisherdev08.simulator.entity;

import java.time.LocalDate;

public class BorrowRecord {
    private Student student;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean returned;

    public BorrowRecord(Student student, Book book, LocalDate borrowDate, LocalDate returnDate, boolean returned){
        this.student = student;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.returned = returned;
    }

    public Student getStudent() {
        return student;
    }
    public Book getBook() {
        return book;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public boolean isReturned() {
        return returned;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "BorrowRecord{" +
                ", student=" + student +
                ", book=" + book +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", returned=" + returned +
                '}';
    }


}
