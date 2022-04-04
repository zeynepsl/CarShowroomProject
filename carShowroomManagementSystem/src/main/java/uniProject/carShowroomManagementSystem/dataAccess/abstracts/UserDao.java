package uniProject.carShowroomManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
