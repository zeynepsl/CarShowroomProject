package uniProject.carShowroomManagementSystem.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.core.entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{

}
