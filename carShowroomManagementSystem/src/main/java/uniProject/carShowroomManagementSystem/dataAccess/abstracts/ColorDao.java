package uniProject.carShowroomManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.entities.concretes.Color;

public interface ColorDao extends JpaRepository<Color, Integer>{
	List<Color> findByName(String name);
}
