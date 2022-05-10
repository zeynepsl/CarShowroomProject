package uniProject.carShowroomManagementSystem.business.abstracts;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.CreateSaleRequestDto;
import uniProject.carShowroomManagementSystem.entity.Car;
import uniProject.carShowroomManagementSystem.entity.Sale;

public interface SaleService extends BaseService<Sale>, AddService<CreateSaleRequestDto>{
	DataResult<List<Sale>> findByIsConfirmTrue();
	DataResult<List<Sale>> findByIsConfirmFalse();
	
	DataResult<List<Sale>> findBySaleDate(LocalDate saleDate);
	DataResult<Set<Car>> findBySaleDateBetweenOrderBySaleCount(LocalDate firstSaleDate, LocalDate lastSaleDate);
	
	DataResult<List<Sale>> findAllByCustomer_Id(int customerId);
	DataResult<List<Sale>> findByCar_Id(int carId);
	
	Result confirmSale(int saleId);
}
