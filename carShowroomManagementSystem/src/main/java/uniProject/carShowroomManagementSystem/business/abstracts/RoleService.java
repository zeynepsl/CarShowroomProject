package uniProject.carShowroomManagementSystem.business.abstracts;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.entity.Role;
import uniProject.carShowroomManagementSystem.dto.RoleDto;

public interface RoleService extends BaseService<Role>, AddService<RoleDto>{

}
