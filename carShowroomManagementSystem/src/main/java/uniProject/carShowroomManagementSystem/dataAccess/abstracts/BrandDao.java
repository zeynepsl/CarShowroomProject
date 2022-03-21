package uniProject.carShowroomManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.entities.concretes.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer>{
	List<Brand> findByName(String name);
}
