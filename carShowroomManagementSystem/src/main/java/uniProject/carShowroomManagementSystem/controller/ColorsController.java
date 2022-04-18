package uniProject.carShowroomManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniProject.carShowroomManagementSystem.business.abstracts.ColorService;
import uniProject.carShowroomManagementSystem.core.utility.result.DataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.Result;
import uniProject.carShowroomManagementSystem.entity.concrete.Color;
import uniProject.carShowroomManagementSystem.entity.dto.ColorDto;

@RestController
@RequestMapping("/api/colors/")
public class ColorsController {
	private ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		this.colorService = colorService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody ColorDto entity) {
		return colorService.add(entity);
	}

	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return colorService.delete(id);
	}

	@PostMapping("update")
	public Result update(Color entity) {
		return colorService.update(entity);
	}

	@GetMapping("getById")
	public DataResult<Color> getById(@RequestParam int id) {
		return colorService.getById(id);
	}

	@GetMapping("getAll")
	public DataResult<List<Color>> getAll() {
		return colorService.getAll();
	}

	@GetMapping("findByName")
	public DataResult<List<Color>> findByName(@RequestParam String name) {
		return colorService.findByName(name);
	}
	
}
