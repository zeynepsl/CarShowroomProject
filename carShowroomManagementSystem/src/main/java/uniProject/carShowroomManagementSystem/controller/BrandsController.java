package uniProject.carShowroomManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniProject.carShowroomManagementSystem.business.abstracts.BrandService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.CreateBrandRequestDto;
import uniProject.carShowroomManagementSystem.entity.Brand;

@RestController

//API endpoint pathi:
//bu path resourcelarımı karşılıyor
@RequestMapping("/api/")//hangi path e gelinmesi gerektigini beliritiyorum
@Validated
public class BrandsController {
	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	//localhost:8080/api/brands yazıldığında bu metot çalışmalı
	//http://localhost:8080/api/brands
	@PostMapping(path = "/brands")
	public Result addBrand(@RequestBody CreateBrandRequestDto entity) {
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
	public DataResult<Brand> getById(@PathVariable int brandId) {
		return brandService.getById(brandId);
	}

	// request url --> http://localhost:8080/api/brands
	@GetMapping(path = "/brands")
	public DataResult<List<Brand>> getAll() {
		return brandService.getAll();
	}

	// http://localhost:8080/api/brands/a
	@GetMapping(path = "/brands/findByName/{name}")
	public DataResult<List<Brand>> findByName(@PathVariable String name) {
		return brandService.findByName(name);
	}
}