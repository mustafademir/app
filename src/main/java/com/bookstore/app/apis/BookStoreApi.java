package com.bookstore.app.apis;

import com.bookstore.app.dtos.BookDto;
import com.bookstore.app.dtos.BookstoreDto;
import com.bookstore.app.mappers.BookMapper;
import com.bookstore.app.mappers.BookstoreMapper;
import com.bookstore.app.services.IBookstoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
@Api(value="Bookstore Management System", description="Bookstore")
public class BookStoreApi {
    @Autowired
    private IBookstoreService bookstoreService;

    @Autowired
    BookstoreMapper bookstoreMapper;

    @Autowired
    BookMapper bookMapper;

    @ApiOperation(value = "View a list of all bookstores", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(produces = "application/json")
    public List<BookstoreDto> findAll() {
        return bookstoreMapper.toBookStoreDtoList(bookstoreService.findAll());
    }

    @PostMapping(produces = "application/json")
    public BookstoreDto createBookstore(BookstoreDto bookstoreDto) {
        return bookstoreMapper.toBookstoreDto(bookstoreService.createBookstore(bookstoreMapper.toBookstore(bookstoreDto)));
    }

    @GetMapping("/bookList")
    public List<BookDto> getBooks(@RequestParam Long bookstoreId) {
       return bookMapper.toBookDtoList(bookstoreService.getBookList(bookstoreId));
    }

    @GetMapping("/addBook")
    public ResponseEntity addBook(@RequestParam Long bookstoreId, @RequestParam Long bookId) {
        bookstoreService.addBook(bookId, bookstoreId);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/removeBook")
    public ResponseEntity removeBook(@RequestParam Long bookstoreId, @RequestParam Long bookId) {
        bookstoreService.removeBook(bookId, bookstoreId);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
