package org.example.structural.service;


import org.example.structural.entity.Book;
import org.springframework.stereotype.Component;
import java.util.List;


import org.example.structural.entity.Book;
import org.example.structural.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;

@Component
public class LibraryFacade {

    private final BookService bookService;

    @Autowired
    public LibraryFacade(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Add a new book to the library.
     *
     * @param book The book entity to be added.
     */
    public void addBook(Book book) {
        bookService.addBook(book);
    }

    public List<Book> getFeaturedBooks() {
        return bookService.getAllFeaturedBooks();
    }

    /**
     * Retrieve all books in the library.
     *
     * @return A list of all books.
     */
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    /**
     * Update the details of an existing book.
     *
     * @param bookId The ID of the book to update.
     * @param book   The updated book data.
     */
    public void updateBook(Long bookId, Book book) {
        bookService.updateBook(bookId, book);
    }

    /**
     * Delete a book by ID.
     *
     * @param bookId The ID of the book to delete.
     */
    public void deleteBook(Long bookId) {
        bookService.deleteBook(bookId);
    }
}

