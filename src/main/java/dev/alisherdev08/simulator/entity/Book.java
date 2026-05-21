package dev.alisherdev08.simulator.entity;

import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private String author;
    private int quantity;
    private boolean isAvailable;

    public Book(UUID id, String title, String author, int quantity, boolean isAvailable){
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.isAvailable = isAvailable;
    }

    public UUID getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getQuantity() {
        return quantity;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
