package uniProject.carShowroomManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniProject.carShowroomManagementSystem.business.abstracts.RoleService;
import uniProject.carShowroomManagementSystem.core.entity.Role;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.CreateRoleRequestDto;

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
	public Result add(@RequestBody CreateRoleRequestDto entity) {
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
