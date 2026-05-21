package dev.alisherdev08.simulator.service;

import dev.alisherdev08.simulator.entity.Book;
import dev.alisherdev08.simulator.entity.BorrowRecord;
import dev.alisherdev08.simulator.repository.BorrowRecordRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


public class BorrowRecordService {

    private BorrowRecordRepository borrowRecordRepository;
    private BookService bookService;

    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository, BookService bookService) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.bookService = bookService;
    }

    public void borrowBook(UUID studentId, UUID bookId, LocalDate borrowDate) {
        Book book = bookService.findBookById(bookId);
        if (book.getQuantity() <= 0) {
            throw new RuntimeException("Book not found: " + bookId);
        }
        if (!book.isAvailable()) {
            throw new RuntimeException("Book is already borrowed.");
        }
        book.setQuantity(book.getQuantity() - 1);
        BorrowRecord record = new BorrowRecord(UUID.randomUUID(), UUID.randomUUID(), borrowDate, null, false);
        borrowRecordRepository.save(record);
    }
    public void returnBook(UUID recordId) {
        BorrowRecord record = borrowRecordRepository.findById(recordId);
        if (record == null) {
            System.out.println("Record not found");
            return;
        }
        if (record.isReturned()) {
            System.out.println("Book already returned");
            return;
        }
        record.setReturned(true);
        record.setReturnDate(LocalDate.now());
        Book book = bookService.findBookById(record.getBookId());
        if (book != null) {
            book.setAvailable(true);
        }
        System.out.println("Book returned successfully");
    }
    public List<BorrowRecord> findActiveBorrows(){
       return  borrowRecordRepository.findActiveBorrows();
    }
     public List<BorrowRecord> findByStudentId(UUID studentId){
        return  borrowRecordRepository.findByStudentId(studentId);
     }


}
