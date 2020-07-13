package com.bookstore.app;

import com.bookstore.app.apis.CategoryApi;
import com.bookstore.app.mappers.CategoryMapper;
import com.bookstore.app.services.ICategoryService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;
import com.bookstore.app.domain.Category;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class CategoryApiUnitTest {
    @InjectMocks
    CategoryApi categoryApi;

    @Mock
    ICategoryService categoryService;

    @Mock
    CategoryMapper categoryMapper;

    @Test
    public void createCategory() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(categoryService.createCategory(any(Category.class))).thenReturn(new Category());
        Category category = new Category();
        category.setId(5L);
        category.setName("newCategory");
        Category response = categoryService.createCategory(category);
        assertThat(response).isNotEqualTo(null);
    }
}
