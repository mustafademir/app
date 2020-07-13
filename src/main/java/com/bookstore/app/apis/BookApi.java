package com.bookstore.app.apis;

import com.bookstore.app.dtos.BookDto;
import com.bookstore.app.mappers.BookMapper;
import com.bookstore.app.services.IBookService;
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
@RequestMapping("/book")
@Api(value="Book Management System", description="Book")
public class BookApi {
    @Autowired
    private IBookService bookService;

    @Autowired
    BookMapper bookMapper;

    @ApiOperation(value = "View a list of all books", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(produces = "application/json")
    public List<BookDto> findAll() {
        return bookMapper.toBookDtoList(bookService.findAll());
    }

    @PostMapping(produces = "application/json")
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookMapper.toBookDto(bookService.createBook(bookMapper.toBook(bookDto)));
    }

    @GetMapping("changeCategory")
    public ResponseEntity changeCategory(@RequestParam Long cId, @RequestParam Long bookId) {
        bookService.changeCategory(cId, bookId);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

}
