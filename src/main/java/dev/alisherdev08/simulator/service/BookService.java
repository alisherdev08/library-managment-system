package dev.alisherdev08.simulator.service;

import dev.alisherdev08.simulator.entity.Book;
import dev.alisherdev08.simulator.repository.BookRepository;

import java.util.List;
import java.util.UUID;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void addBook(String title, String author, int quantity) {
        Book book = new Book(UUID.randomUUID(), title, author, quantity);
        book.setAvailable(quantity > 0);
        bookRepository.save(book);
        System.out.println("Book added successfully: " + book.getId());
    }
    public void removeBook(UUID bookId){
        Book book = bookRepository.findByID(bookId);
        if(bookId != null){
            bookRepository.deleteByID(bookId);
            System.out.println("Book removed successfully: " + book.getId());
        } else{
            System.out.println("Book not found: " + bookId);
        }
    }
    public Book findBookById(UUID bookId){
        return bookRepository.findByID(bookId);
    }
    public List<Book> searchBookByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }
    public List<Book> searchBookByTitle(String title){
        return bookRepository.findByTitle(title);
    }
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

}
