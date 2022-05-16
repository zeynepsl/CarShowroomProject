package uniProject.carShowroomManagementSystem.dataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.core.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String email);
}
