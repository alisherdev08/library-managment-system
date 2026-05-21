package dev.alisherdev08.simulator.entity;

import java.time.LocalDate;
import java.util.UUID;

public class BorrowRecord {
    private UUID studentId;
    private UUID bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean returned;

    public BorrowRecord(UUID studentID, UUID bookId, LocalDate borrowDate, LocalDate returnDate, boolean returned){
        this.studentId = studentID;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.returned = returned;
    }

    public UUID getStudentID() {
        return studentId;
    }
    public UUID getBookId() {
        return bookId;
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
                ", studentID=" + studentId +
                ", book=" + bookId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", returned=" + returned +
                '}';
    }

}
