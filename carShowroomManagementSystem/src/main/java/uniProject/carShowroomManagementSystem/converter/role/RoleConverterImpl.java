package uniProject.carShowroomManagementSystem.converter.role;

import org.springframework.stereotype.Component;

import uniProject.carShowroomManagementSystem.core.entity.Role;
import uniProject.carShowroomManagementSystem.dto.CreateRoleRequestDto;

@Component
public class RoleConverterImpl implements RoleConverter{
	@Override
	public Role toRole(CreateRoleRequestDto createRoleRequestDto) {
		Role role = new Role();
		role.setName(createRoleRequestDto.getName());
		return role;
	}
}
