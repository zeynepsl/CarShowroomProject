package uniProject.carShowroomManagementSystem.converter.role;

import uniProject.carShowroomManagementSystem.core.entity.Role;
import uniProject.carShowroomManagementSystem.dto.role.CreateRoleRequestDto;

public interface RoleConverter {

	Role toRole(CreateRoleRequestDto createRoleRequestDto);

}
