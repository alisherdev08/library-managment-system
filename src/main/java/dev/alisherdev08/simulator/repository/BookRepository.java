package dev.alisherdev08.simulator.repository;

import dev.alisherdev08.simulator.entity.Book;
import  java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class BookRepository {
    private List<Book> books  = new ArrayList<>();

    public void save(Book book){
        books.add(book);
    }
    public List<Book> findAll(){
        return  books;
    }

    public Book findByID(UUID id){
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }
    public void deleteByID(UUID id){
        books.removeIf(book -> book.getId().equals(id));
    }
    public List<Book> findByAuthor(String author){
        return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).toList();
    }
    public List<Book> findByTitle(String title){
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).toList();
    }
}
