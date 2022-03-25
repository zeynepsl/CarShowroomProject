package uniProject.carShowroomManagementSystem.business.abstracts;

import java.time.LocalTime;
import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.entities.concretes.TestDrive;

public interface TestDriveService extends BaseService<TestDrive>{
	DataResult<List<TestDrive>> findByIsConfirmTrue();
	DataResult<List<TestDrive>> findByIsConfirmFalse();
	
	DataResult<List<TestDrive>> findBytestDate(LocalTime testDate);
	
	DataResult<List<TestDrive>> findAllByCustomer_Id(int customerId);
	DataResult<List<TestDrive>> findAllByCar_Id(int carId);
}
