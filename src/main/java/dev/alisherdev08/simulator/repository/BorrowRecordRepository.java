package dev.alisherdev08.simulator.repository;

import dev.alisherdev08.simulator.entity.BorrowRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BorrowRecordRepository {
    private List<BorrowRecord> records = new ArrayList<>();

    public List<BorrowRecord> findActiveBorrows() {
        return records.stream()
                .filter(borrowRecord -> !borrowRecord.isReturned())
                .toList();
    }
    public List<BorrowRecord> findByStudentId(UUID studentId){
        return records.stream().filter(borrowRecord -> borrowRecord.getStudentID().equals(studentId)).toList();
    }







}
