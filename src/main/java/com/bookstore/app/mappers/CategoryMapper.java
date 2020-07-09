package com.bookstore.app.mappers;

import com.bookstore.app.domain.Category;
import com.bookstore.app.dtos.CategoryDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CategoryMapper {

    Category toCategory(CategoryDto categoryDto);

    CategoryDto toCategoryDto(Category category);

    List<Category> toCategoryList(List<CategoryDto> categoryDtoList);

    List<CategoryDto> toCategoryDtoList(List<Category> categories);
}
