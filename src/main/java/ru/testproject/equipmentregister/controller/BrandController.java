package ru.testproject.equipmentregister.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.testproject.equipmentregister.dto.BrandDto;
import ru.testproject.equipmentregister.service.BrandService;

import java.util.List;

@Tag(name = "Brand controller",
        description = "The responsibilities of controller are: creating, updating, deleting and finding information about brands. ")
@RestController
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @Operation(
            summary = "The providing possibility to find all brands  ",
            description = "It allows to find all brands  "
    )
    @GetMapping("/all")
    public List<BrandDto> getAllBrands() {
        return brandService.findAll();
    }

    @Operation(
            summary = "The providing possibility to find brand by id  ",
            description = "It allows to find brand by id"
    )
    @GetMapping("/{id}")
    public BrandDto getBrandById(@PathVariable(name = "id", required = true)
                                 @Parameter(description = "value for setting id, to find brand ", required = true)
                                 Long id) {
        return brandService.findById(id);
    }

    @Operation(
            summary = "The providing possibility to create brand  ",
            description = "It allows to create new brand "
    )
    @PostMapping(value = "/create")
    public BrandDto createBrand(@RequestBody
                                @Parameter(description = "create new brand by received Json ", required = true)
                                BrandDto brandDto) {
        return brandService.create(brandDto);
    }

    @Operation(
            summary = "The providing possibility to update brand  ",
            description = "it allows to update already existing brand  "
    )
    @PutMapping(value = "/update/{brandId}")
    public BrandDto updateBrand(@PathVariable(value = "brandId") int categoryId,
                                @RequestBody
                                @Parameter(description = "update brand by received Json ", required = true)
                                BrandDto brandDto) {
        brandService.update(brandDto);
        return brandDto;
    }

    @Operation(
            summary = "The providing possibility to delete brand  ",
            description = "it allows to delete already existing brand  "
    )
    @DeleteMapping("/{brandId}")
    public void deleteBrand(@PathVariable(name = "brandId")
                            @Parameter(description = "delete brand by getting a brand id and received Json ", required = true)
                            int brandId) {
        brandService.delete(brandId);
    }

}
