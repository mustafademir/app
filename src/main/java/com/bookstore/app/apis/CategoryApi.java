package com.bookstore.app.apis;

import com.bookstore.app.dtos.BookDto;
import com.bookstore.app.dtos.CategoryDto;
import com.bookstore.app.mappers.BookMapper;
import com.bookstore.app.mappers.CategoryMapper;
import com.bookstore.app.services.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Api(value="Category Management System", description="Category")
public class CategoryApi {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    BookMapper bookMapper;

    @ApiOperation(value = "View a list of all Categories", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(produces = "application/json")
    public List<CategoryDto> findAll() {
        return categoryMapper.toCategoryDtoList(categoryService.findAll());
    }

    @PostMapping(produces = "application/json")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryMapper.toCategoryDto(categoryService.createCategory(categoryMapper.toCategory(categoryDto)));
    }

    @GetMapping("/listBook")
    public List<BookDto> listBooks(@RequestParam Long cId) {
        return bookMapper.toBookDtoList(categoryService.listBooks(cId));
    }
}
