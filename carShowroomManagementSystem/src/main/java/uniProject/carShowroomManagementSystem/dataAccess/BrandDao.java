package uniProject.carShowroomManagementSystem.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.entity.Brand;


public interface BrandDao extends JpaRepository<Brand, Integer>{
	List<Brand> findByName(String name);
}
