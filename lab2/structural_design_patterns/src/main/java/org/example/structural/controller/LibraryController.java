package org.example.structural.controller;

import io.swagger.annotations.ApiParam;
import org.example.structural.dto.BookDto;
import org.example.structural.entity.Book;
import org.example.structural.repository.BookRepository;
import org.example.structural.utils.BookMapper;
import org.example.structural.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class LibraryController {

    private final BookService bookService;

    @Autowired
    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Retrieve all books", description = "Returns a list of all books in the library as BookDto objects")
    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks()
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Retrieve all books", description = "Returns a list of all books in the library as BookDto objects")
    @GetMapping("/get-featured")
    public List<BookDto> getAllFeaturedBooks() {
        return bookService.getAllFeaturedBooks()
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Get a book by ID", description = "Provide an ID to lookup a specific book in the library")
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@ApiParam("ID of the book to retrieve") @PathVariable Long id) {
        return (bookService.findBookById(id));
    }

    @Operation(summary = "Add a new book", description = "Adds a new book to the library and returns the saved BookDto object")
    @PostMapping
    public BookDto addBook(@ApiParam("BookDto object to be added") @RequestBody BookDto BookDto) {
        Book book = BookMapper.toEntity(BookDto);
        Book savedBook = bookService.addBook(book);
        return BookMapper.toDTO(savedBook);
    }

    @Operation(summary = "Update an existing book", description = "Updates an existing book by ID with new information from the BookDto object")
    @PutMapping("/{id}")
    public Optional<Book> updateBook(
            @ApiParam("ID of the book to update") @PathVariable Long id,
            @ApiParam( "Updated BookDto object") @RequestBody BookDto updatedBookDto) {

        Book book = BookMapper.toEntity(updatedBookDto);
        Optional<Book> updatedBook = bookService.updateBook(id, book); // Implemented in BookService
//        return BookMapper.toDTO(new Book());
        return (bookService.findBookById(id));
    }

    @Operation(summary = "Delete a book by ID", description = "Deletes the book with the specified ID from the library")
    @DeleteMapping("/{id}")
    public Optional<Book> deleteBook(@ApiParam("ID of the book to delete") @PathVariable Long id) {
    //TODO
        Optional<Book> bk = bookService.findBookById(id);
        bookService.deleteBook(id);
        return bk;
    }
}