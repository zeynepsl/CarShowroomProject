package uniProject.carShowroomManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniProject.carShowroomManagementSystem.business.abstracts.BrandService;
import uniProject.carShowroomManagementSystem.core.utility.result.DataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.Result;
import uniProject.carShowroomManagementSystem.entity.concrete.Brand;
import uniProject.carShowroomManagementSystem.entity.dto.BrandDto;

@RestController

//API endpoint pathi:
//bu path resourcelarımı karşılıyor
@RequestMapping("/api/brands/")//hangi path e gelinmesi gerektigini beliritiyorum
@Validated
public class BrandsController {
	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	//localhost:8080/api/brands/add yazıldığında bu metot çalışmalı
	@PostMapping("add")
	public Result add(@RequestBody BrandDto entity) {
		return brandService.add(entity);
	}
	


	@PostMapping("delete")
	public Result delete(@RequestParam @Positive(message = "id must be positive") int id) {
		return brandService.delete(id);
	}

	@PostMapping("update")
	public Result update(@RequestBody @Valid Brand entity) {
		return brandService.update(entity);
	}

	@GetMapping("getById")
	public DataResult<Brand> getById(@RequestParam int id) {
		return brandService.getById(id);
	}

	@GetMapping("getAll")
	public DataResult<List<Brand>> getAll() {
		return brandService.getAll();
	}

	@GetMapping("findByName")
	public DataResult<List<Brand>> findByName(@RequestParam String name) {
		return brandService.findByName(name);
	}
}
