package dev.alisherdev08.simulator.repository;

import dev.alisherdev08.simulator.entity.BorrowRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BorrowRecordRepository {
    private List<BorrowRecord> records = new ArrayList<>();

    public void save(BorrowRecord record){
        records.add(record);
    }
    public List<BorrowRecord> findActiveBorrows() {
        return records.stream()
                .filter(borrowRecord -> !borrowRecord.isReturned())
                .toList();
    }
    public List<BorrowRecord> findByStudentId(UUID studentId){
        return records.stream().filter(borrowRecord -> borrowRecord.getStudentID().equals(studentId)).toList();
    }
    public List<BorrowRecord> findByBookId(UUID bookId){
        return records.stream().filter(borrowRecord -> borrowRecord.getBookId().equals(bookId)).toList();
    }
    public BorrowRecord findById(UUID recordId){
        return records.stream().filter(borrowRecord -> borrowRecord.getBookId().equals(recordId)).findFirst().orElse(null);
    }





}
