package uniProject.carShowroomManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniProject.carShowroomManagementSystem.business.abstracts.RoleService;
import uniProject.carShowroomManagementSystem.core.entities.Role;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.core.utilities.results.Result;
import uniProject.carShowroomManagementSystem.entities.dtos.RoleDto;

@RestController
@RequestMapping("/api/roles/")
public class RolesController {
	private RoleService roleService;

	@Autowired
	public RolesController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody RoleDto entity) {
		return roleService.add(entity);
	}
	
	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return roleService.delete(id);
	}

	@PostMapping("update")
	public Result update(@RequestBody Role entity) {
		return roleService.update(entity);
	}

	@GetMapping("getById")
	public DataResult<Role> getById(@RequestParam int id) {
		return roleService.getById(id);
	}

	@GetMapping("getAll")
	public DataResult<List<Role>> getAll() {
		return roleService.getAll();
	}
}
