package uniProject.carShowroomManagementSystem.business.abstracts;

import java.time.LocalTime;
import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.entities.concretes.Sale;

public interface SaleService extends BaseService<Sale>{
	DataResult<List<Sale>> findByIsConfirmTrue();
	DataResult<List<Sale>> findByIsConfirmFalse();
	
	DataResult<List<Sale>> findBySaleDate(LocalTime saleDate);
	
	DataResult<List<Sale>> findAllByCustomer_Id(int customerId);
	DataResult<List<Sale>> findByCar_Id(int carId);
}
