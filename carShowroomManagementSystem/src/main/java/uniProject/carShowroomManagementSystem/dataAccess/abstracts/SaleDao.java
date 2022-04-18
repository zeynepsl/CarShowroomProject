package uniProject.carShowroomManagementSystem.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.entity.concrete.Sale;


public interface SaleDao extends JpaRepository<Sale, Integer>{
	List<Sale> findByIsConfirmTrue();
	List<Sale> findByIsConfirmFalse();
	
	List<Sale> findBySaleDate(LocalDate saleDate);
	List<Sale> findBySaleDateBetweenOrderByCar_SaleCount(LocalDate firstSaleDate, LocalDate lastSaleDate);
	
	List<Sale> findAllByCustomer_Id(int customerId);
    List<Sale> findByCar_Id(int carId);
}
