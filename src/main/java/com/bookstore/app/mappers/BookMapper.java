package com.bookstore.app.mappers;

import com.bookstore.app.domain.Book;
import com.bookstore.app.dtos.BookDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface BookMapper {
    List<BookDto> toBookDtoList(List<Book> book);

    List<Book> toBookEntityList(List<BookDto> bookDtos);

    Book toBook(BookDto bookDto);

    BookDto toBookDto(Book book);
}
