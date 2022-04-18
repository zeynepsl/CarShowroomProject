package uniProject.carShowroomManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.entity.concrete.TestDrive;


public interface TestDriveDao extends JpaRepository<TestDrive, Integer>{
	List<TestDrive> findByIsConfirmTrue();
	List<TestDrive> findByIsConfirmFalse();
	
	/*List<TestDrive> findBytestDate(LocalDate testDate);
	
	List<TestDrive> findAllByCustomer_Id(int customerId);*/
	//List<TestDrive> findAllByCar_Id(int carId);
}
