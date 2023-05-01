package ru.testproject.equipmentregister.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.testproject.equipmentregister.dto.CategoryDto;

import ru.testproject.equipmentregister.service.CategoryService;

import java.util.List;

@Tag(name = "Category controller",
        description = "The responsibilities of controller are: creating, updating, deleting and finding information about categories. ")
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(
            summary = "The providing possibility to find all categories  ",
            description = "It allows to find all categories  "
    )
    @GetMapping("/all")
    public List<CategoryDto> getAllCategories() {
        return categoryService.findAll();
    }

    @Operation(
            summary = "The providing possibility to find category by id  ",
            description = "It allows to find category by id"
    )
    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable(name = "id", required = true)
                                       @Parameter(description = "value for setting id, to find category ", required = true)
                                       Long id) {
        return categoryService.findById(id);
    }

    @Operation(
            summary = "The providing possibility to create category  ",
            description = "It allows to create new category "
    )
    @PostMapping(value = "/create")
    public CategoryDto createCategory(@RequestBody
                                      @Parameter(description = "create new category by received Json ", required = true)
                                      CategoryDto categoryDto) {
        return categoryService.create(categoryDto);
    }

    @Operation(
            summary = "The providing possibility to update category  ",
            description = "it allows to update already existing category  "
    )
    @PutMapping(value = "/update/{categoryId}")
    public CategoryDto updateCategory(@PathVariable(value = "categoryId") int categoryId,
                                      @RequestBody
                                      @Parameter(description = "update category by received Json ", required = true)
                                      CategoryDto categoryDto) {
        categoryService.update(categoryDto);
        return categoryDto;
    }

    @Operation(
            summary = "The providing possibility to delete category  ",
            description = "it allows to delete already existing category  "
    )
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable(name = "categoryId")
                               @Parameter(description = "delete category by getting a category id and received Json ", required = true)
                               int categoryId) {
        categoryService.delete(categoryId);
    }

}
