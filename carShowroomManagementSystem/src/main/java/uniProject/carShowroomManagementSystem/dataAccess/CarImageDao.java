package uniProject.carShowroomManagementSystem.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.entity.CarImage;

public interface CarImageDao extends JpaRepository<CarImage, Integer>{
	List<CarImage> findByCar_Id(int carId);
	
}
