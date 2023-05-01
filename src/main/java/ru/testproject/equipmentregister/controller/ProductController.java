package ru.testproject.equipmentregister.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.testproject.equipmentregister.dto.ProductDto;
import ru.testproject.equipmentregister.service.ProductService;


import java.util.List;

@Tag(name = "Product controller",
        description = "The responsibilities of controller are: creating, updating, deleting and finding information about products. ")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
            summary = "The providing possibility to find all products ",
            description = "It allows to find all product  "
    )
    @GetMapping("/all")
    public List<ProductDto> getAllProduct() {
        return productService.findAll();
    }

    @Operation(
            summary = "The providing possibility to find all products by their category ",
            description = "It allows to find all product by their categoryId "
    )
    @GetMapping("/allproductsbycategory/{categoryId}")
    public List<ProductDto> getAllProductByCategory(@PathVariable(name = "categoryId", required = true)
                                                    @Parameter(description = "value for setting the category id, to find products ", required = true)
                                                    Long categoryId) {
        return productService.findAllProductByCategoryId(categoryId);
    }

    @Operation(
            summary = "The providing possibility to find all products by their name ",
            description = "It allows to find all product by their name "
    )
    @GetMapping("/allproductsbyname/{productName}")
    public List<ProductDto> getAllProductByName(@PathVariable(name = "productName", required = true)
                                                @Parameter(description = "value for setting the product name, to find products ", required = true)
                                                String productName) {
        return productService.findAllProductByName(productName);
    }

    @Operation(
            summary = "The providing possibility to find all products by their color ",
            description = "It allows to find all product by their color "
    )
    @GetMapping("/allproductsbycolor/{productColor}")
    public List<ProductDto> getAllProductByColor(@PathVariable(name = "productColor", required = true)
                                                 @Parameter(description = "value for setting the color, to find products ", required = true)
                                                 String productColor) {
        return productService.findAllProductByColor(productColor);
    }

    @Operation(
            summary = "The providing possibility to find all products by their price ",
            description = "It allows to find all product by their price in range from start to end values "
    )
    @GetMapping("/allproductsbypricebetween/{start}/{end}")
    public List<ProductDto> getAllProductByPriceBetween(@Parameter(description = "values for setting range between start and end, to find products", required = true)
                                                        @PathVariable int start, @PathVariable int end) {
        return productService.findAllProductByPriceBetween(start, end);
    }

    @Operation(
            summary = "The providing possibility to find product by id  ",
            description = "It allows to find all product by their price in range from start to end values "
    )
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable(name = "id", required = true)
                                     @Parameter(description = "value for setting the id, to find products ", required = true)
                                     Long id) {
        return productService.findById(id);
    }

    @Operation(
            summary = "The providing possibility to create product  ",
            description = "It allows to create new product "
    )
    @PostMapping(value = "/create")
    public ProductDto createProduct(@RequestBody
                                    @Parameter(description = "create new product by received Json ", required = true)
                                    ProductDto productDto) {
        return productService.create(productDto);
    }

    @Operation(
            summary = "The providing possibility to update product  ",
            description = "it allows to update already existing product  "
    )
    @PutMapping(value = "/update/{productId}")
    public ProductDto updateProduct(@PathVariable(value = "productId") int userId,
                                    @RequestBody
                                    @Parameter(description = "update product by received Json ", required = true)
                                    ProductDto productDto) {
        productService.update(productDto);
        return productDto;
    }

    @Operation(
            summary = "The providing possibility to delete product  ",
            description = "it allows to delete already existing product  "
    )
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable(name = "productId")
                              @Parameter(description = "delete product by getting a product id and received Json ", required = true)
                              int productId) {
        productService.delete(productId);
    }

}
