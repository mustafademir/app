package com.bookstore.app.mappers;

import com.bookstore.app.domain.Bookstore;
import com.bookstore.app.dtos.BookstoreDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BookstoreMapper {
    Bookstore toBookstore(BookstoreDto bookstoreDto);

    BookstoreDto toBookstoreDto(Bookstore bookstore);

    List<Bookstore> toBookStoreList(List<BookstoreDto> bookstoreDtos);

    List<BookstoreDto> toBookStoreDtoList(List<Bookstore> bookstores);
}
