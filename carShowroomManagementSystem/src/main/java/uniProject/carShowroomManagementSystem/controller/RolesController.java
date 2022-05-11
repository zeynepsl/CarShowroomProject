package uniProject.carShowroomManagementSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.RoleService;
import uniProject.carShowroomManagementSystem.core.entity.Role;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.CreateRoleRequestDto;

@RestController
@RequestMapping("/api/roles/")
@RequiredArgsConstructor
public class RolesController {
	private final RoleService roleService;
	
	@PostMapping("/")
	public Result add(@RequestBody CreateRoleRequestDto entity) {
		return roleService.add(entity);
	}
	
	@DeleteMapping("{id}")
	public Result delete(@PathVariable int id) {
		return roleService.delete(id);
	}

	@PutMapping("/")
	public Result update(@RequestBody Role entity) {
		return roleService.update(entity);
	}

	@GetMapping("{id}")
	public DataResult<Role> getById(@PathVariable int id) {
		return roleService.getById(id);
	}

	@GetMapping("getAll")
	public DataResult<List<Role>> getAll() {
		return roleService.getAll();
	}
}
