package org.example.structural.service;

import org.example.structural.entity.Book;
import org.example.structural.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // TODO: Implement methods for CRUD operations

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getAllFeaturedBooks() {
        return bookRepository.findByIsFeaturedTrue();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id).map(existingBook -> {
            // Update existing book details with the new details
//            existingBook.setId(updatedBook.getId());
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setIsFeatured(updatedBook.getIsFeatured());
//            existingBook.setCategory(updatedBook.getCategory());


            // Save the updated book
            return bookRepository.save(existingBook);
        });
    }
}
