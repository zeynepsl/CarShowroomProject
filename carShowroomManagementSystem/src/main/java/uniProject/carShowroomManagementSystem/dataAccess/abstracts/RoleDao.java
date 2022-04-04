package uniProject.carShowroomManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.core.entities.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{

}
