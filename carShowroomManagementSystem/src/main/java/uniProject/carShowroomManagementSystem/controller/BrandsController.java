package uniProject.carShowroomManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.BrandService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.brand.BrandResponseDto;
import uniProject.carShowroomManagementSystem.dto.brand.CreateBrandRequestDto;
import uniProject.carShowroomManagementSystem.entity.Brand;
import uniProject.carShowroomManagementSystem.validationRule.brand.BrandValidator;

//API endpoint pathi:
//bu path resourcelarımı karşılıyor

@RestController
@RequestMapping("/api/")//hangi path e gelinmesi gerektigini beliritiyorum
@Validated
@RequiredArgsConstructor
public class BrandsController {
	private final BrandService brandService;
	private final BrandValidator brandValidator;
	
	//localhost:8080/api/brands yazıldığında bu metot çalışmalı
	//http://localhost:8080/api/brands
	@PostMapping(path = "/brands")
	public Result addBrand(@Valid @RequestBody CreateBrandRequestDto entity) {
		return brandService.add(entity);
	}
	
	// http://localhost:8080/api/brands/3
	@DeleteMapping(path = "/brands/{brandId}")
	public Result delete(@PathVariable @Positive(message = "id must be positive") int brandId) {
		return brandService.delete(brandId);
	}

	// http://localhost:8080/api/brands
	@PutMapping(path = "/brands")
	public Result update(@RequestBody @Valid Brand entity) {
		return brandService.update(entity);
	}

	// http://localhost:8080/api/brands/3
	@GetMapping(path = "/brands/getById/{brandId}")
	public DataResult<BrandResponseDto> getById(@PathVariable int brandId) {
		return brandService.get(brandId);
	}

	// request url --> http://localhost:8080/api/brands
	@GetMapping(path = "/brands")
	public DataResult<List<BrandResponseDto>> getAll() {
		return brandService.getAll();
	}

	// http://localhost:8080/api/brands/a
	@GetMapping(path = "/brands/findByName/{name}")
	public DataResult<List<BrandResponseDto>> findByName(@PathVariable String name) {
		return brandService.findByName(name);
	}
}
