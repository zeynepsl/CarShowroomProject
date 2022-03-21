package uniProject.carShowroomManagementSystem.dataAccess.abstracts;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.entities.concretes.Sale;

public interface SaleDao extends JpaRepository<Sale, Integer>{
	List<Sale> findByIsConfirmTrue();
	List<Sale> findByIsConfirmFalse();
	
	List<Sale> findBySaleDate(LocalTime saleDate);
	
	List<Sale> findAllByCustomer_Id(int customerId);
    Sale findByCar_Id(int carId);
}
