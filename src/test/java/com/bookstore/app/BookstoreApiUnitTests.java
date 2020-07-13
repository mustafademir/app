package com.bookstore.app;

import com.bookstore.app.apis.BookStoreApi;
import com.bookstore.app.domain.Bookstore;
import com.bookstore.app.mappers.BookstoreMapper;
import com.bookstore.app.services.IBookstoreService;
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
class BookstoreApiUnitTests {
    @InjectMocks
    BookStoreApi bookStoreApi;

    @Mock
    IBookstoreService bookstoreService;

    @Mock
    BookstoreMapper bookstoreMapper;

    @Test
    public void changeCategory() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(bookstoreService.addBook(any(Long.class),any(Long.class))).thenReturn(new Bookstore());

        ResponseEntity<Object> responseEntity = bookStoreApi.addBook(1L,5L);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void removeBook() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(bookstoreService.removeBook(any(Long.class),any(Long.class))).thenReturn(new Bookstore());

        ResponseEntity<Object> responseEntity = bookStoreApi.removeBook(1L,5L);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}
