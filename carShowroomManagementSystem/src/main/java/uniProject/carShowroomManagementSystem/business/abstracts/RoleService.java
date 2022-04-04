package uniProject.carShowroomManagementSystem.business.abstracts;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.entities.Role;
import uniProject.carShowroomManagementSystem.entities.dtos.RoleDto;

public interface RoleService extends BaseService<Role>, AddService<RoleDto>{

}
