package dev.alisherdev08.simulator.app;

import dev.alisherdev08.simulator.entity.Book;
import dev.alisherdev08.simulator.entity.BorrowRecord;
import dev.alisherdev08.simulator.entity.Student;
import dev.alisherdev08.simulator.repository.BookRepository;
import dev.alisherdev08.simulator.repository.BorrowRecordRepository;
import dev.alisherdev08.simulator.repository.StudentRepository;
import dev.alisherdev08.simulator.service.BookService;
import dev.alisherdev08.simulator.service.BorrowRecordService;
import dev.alisherdev08.simulator.service.StudentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BookRepository bookRepository = new BookRepository();
        StudentRepository studentRepository = new StudentRepository();
        BorrowRecordRepository borrowRecordRepository = new BorrowRecordRepository();
        BookService bookService = new BookService(bookRepository);
        StudentService studentService = new StudentService(studentRepository);
        BorrowRecordService borrowRecordService = new BorrowRecordService(borrowRecordRepository, bookService);

        while (true) {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student");
            System.out.println("4. Find Student by ID");
            System.out.println("5. Get All Students");
            System.out.println("6. Add Book");
            System.out.println("7. Remove Book");
            System.out.println("8. Borrow Book");
            System.out.println("9. Return Book");
            System.out.println("10. Get Book by Title");
            System.out.println("11. Get Book by Author");
            System.out.println("12. Get All Books");
            System.out.println("13. Get Active Borrows");
            System.out.println("14. Find Borrow by Student ID");
            System.out.println("15. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    studentService.addStudent(name);
                    System.out.println("Student added.");
                }
                case 2 -> {
                    System.out.println("Enter Student ID :");
                    UUID id = UUID.fromString(scanner.nextLine());
                    studentService.removeStudent(id);
                    System.out.println("Student removed.");
                }
                case 3 -> {
                    System.out.println("Enter Student ID: ");
                    UUID id = UUID.fromString(scanner.nextLine());
                    System.out.println("Enter new full name: ");
                    String newFullName = scanner.nextLine();
                    studentService.updateStudent(id, newFullName);
                    System.out.println("Student updated successfully");
                }
                case 4 -> {
                    System.out.println("Enter Student ID: ");
                    UUID id = UUID.fromString(scanner.nextLine());
                    Student student = studentService.findStudentById(id);
                    if (student == null){
                        System.out.println("Student not found.");
                    } else{
                        System.out.println(student);
                    }
                }
                case 5 -> {
                    System.out.println("\n=== STUDENT LIST ===");
                    List<Student> students = studentService.getAllStudents();
                    if (students.isEmpty()){
                        System.out.println("No students in the list.");
                    } else{
                        students.forEach(System.out::println);
                    }
                }
                case 6 -> {
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    bookService.addBook(title, author, quantity);
                }
                case 7 -> {
                    System.out.print("Enter book ID to remove: ");
                    UUID id = UUID.fromString(scanner.nextLine());
                    bookService.removeBook(id);
                }
                case 8 -> {
                    System.out.print("Enter student ID: ");
                    UUID studentId = UUID.fromString(scanner.nextLine());
                    System.out.print("Enter book ID: ");
                    UUID bookId = UUID.fromString(scanner.nextLine());
                    borrowRecordService.borrowBook(studentId, bookId, LocalDate.now());
                    System.out.println("Book borrowed.");
                }
                case 9 -> {
                    System.out.print("Enter borrow record ID: ");
                    UUID recordId = UUID.fromString(scanner.nextLine());
                    borrowRecordService.returnBook(recordId);
                    System.out.println("Book returned.");
                }
                case 10 -> {
                    System.out.println("Enter book title: ");
                    String title = scanner.nextLine();
                    List<Book> books = bookService.searchBookByTitle(title);
                    if (books.isEmpty()){
                        System.out.println("There is no books with this title.");
                    }  else{
                        books.forEach(System.out::println);
                    }
                }
                case 11 -> {
                    System.out.println("Enter book author: ");
                    String author = scanner.nextLine();
                    List<Book> books = bookService.searchBookByAuthor(author);
                    if (books.isEmpty()){
                        System.out.println("There is no books by this author.");
                    } else{
                        books.forEach(System.out::println);
                    }
                }
                case 12 -> {
                    System.out.println("\n=== BOOK LIST ===");
                    List<Book> books = bookService.findAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        books.forEach(System.out::println);
                    }
                }
                case 13 -> {
                     System.out.println("\n=== ACTIVE BORROWS ===");
                     List<BorrowRecord>  activeBorrows = borrowRecordService.getActiveBorrows();
                     if (activeBorrows.isEmpty()){
                         System.out.println("No active borrows.");
                     } else{
                         activeBorrows.forEach(System.out::println);
                     }
                }
                case 14 -> {
                    System.out.println("Enter Student ID: ");
                    UUID id = UUID.fromString(scanner.nextLine());
                    List<BorrowRecord> records = borrowRecordService.findByStudentId(id);
                    if (records.isEmpty()){
                        System.out.println("This student does not have any borrows");
                    } else {
                        records.forEach(System.out::println);
                    }
                }
                case 15 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
