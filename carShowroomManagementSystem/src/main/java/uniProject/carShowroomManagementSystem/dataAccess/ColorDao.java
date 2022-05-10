package uniProject.carShowroomManagementSystem.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.entity.Color;


public interface ColorDao extends JpaRepository<Color, Integer>{
	List<Color> findByName(String name);
}
