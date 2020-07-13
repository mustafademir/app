package com.bookstore.app;

import com.bookstore.app.apis.BookApi;
import com.bookstore.app.domain.Book;
import com.bookstore.app.domain.Category;
import com.bookstore.app.mappers.BookMapper;
import com.bookstore.app.services.IBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class BookApiUnitTests {
    @InjectMocks
    BookApi bookApi;

    @Mock
    IBookService bookService;

    @Mock
    BookMapper bookMapper;

    @Test
    public void createBook() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(bookService.createBook(any(Book.class))).thenReturn(new Book());
        Book book = new Book();
        book.setBook_id(10L);
        book.setCategory(null);
        book.setPrice(20L);
        book.setName("denemeBook");
        Category category = new Category();
        category.setId(4L);
        category.setName("string");
        book.setCategory(category);
        Book response = bookService.createBook(book);
        assertThat(response).isNotEqualTo(null);
    }

    @Test
    public void changeCategory() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(bookService.changeCategory(any(Long.class),any(Long.class))).thenReturn(1);

        ResponseEntity<Object> responseEntity = bookApi.changeCategory(1L,5L);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

}
