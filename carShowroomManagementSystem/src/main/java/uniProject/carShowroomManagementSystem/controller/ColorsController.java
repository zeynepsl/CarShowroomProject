package uniProject.carShowroomManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.ColorService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.color.ColorResponseDto;
import uniProject.carShowroomManagementSystem.dto.color.CreateColorRequestDto;
import uniProject.carShowroomManagementSystem.entity.Color;

@Validated
@RestController
@RequestMapping("/api/colors")
@RequiredArgsConstructor
public class ColorsController {
	private final ColorService colorService;
	
	@PostMapping("/")
	public Result add(@Valid @RequestBody CreateColorRequestDto entity) {
		return colorService.add(entity);
	}

	@DeleteMapping("{id}")
	public Result delete(@PathVariable int id) {
		return colorService.delete(id);
	}

	@PutMapping("/")
	public Result update(@RequestBody Color entity) {
		return colorService.update(entity);
	}
	
	@GetMapping("{id}")
	public DataResult<ColorResponseDto> getById(@PathVariable int id) {
		return colorService.get(id);
	}

	@GetMapping("getAll")
	public DataResult<List<ColorResponseDto>> getAll() {
		return colorService.getAll();
	}

	@GetMapping("/")
	public DataResult<List<ColorResponseDto>> findByName(@RequestParam String name) {
		return colorService.findByName(name);
	}
	
}
