package uniProject.carShowroomManagementSystem.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.core.utilities.results.Result;
import uniProject.carShowroomManagementSystem.entities.concretes.Car;
import uniProject.carShowroomManagementSystem.entities.concretes.Sale;
import uniProject.carShowroomManagementSystem.entities.dtos.SaleDto;

public interface SaleService extends BaseService<Sale>, AddService<SaleDto>{
	DataResult<List<Sale>> findByIsConfirmTrue();
	DataResult<List<Sale>> findByIsConfirmFalse();
	
	DataResult<List<Sale>> findBySaleDate(LocalDate saleDate);
	DataResult<List<Car>> findBySaleDateBetweenOrderBySaleCount(LocalDate firstSaleDate, LocalDate lastSaleDate);
	
	DataResult<List<Sale>> findAllByCustomer_Id(int customerId);
	DataResult<List<Sale>> findByCar_Id(int carId);
	
	Result confirmSale(int saleId);
}
