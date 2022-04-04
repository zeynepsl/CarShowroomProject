package uniProject.carShowroomManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniProject.carShowroomManagementSystem.business.abstracts.BrandService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.core.utilities.results.Result;
import uniProject.carShowroomManagementSystem.entities.concretes.Brand;
import uniProject.carShowroomManagementSystem.entities.dtos.BrandDto;

@RestController
@RequestMapping("/api/brands/")
public class BrandsController {
	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody BrandDto entity) {
		return brandService.add(entity);
	}

	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return brandService.delete(id);
	}

	@PostMapping("update")
	public Result update(Brand entity) {
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
