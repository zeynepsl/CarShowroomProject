package uniProject.carShowroomManagementSystem.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.utility.result.DataResult;
import uniProject.carShowroomManagementSystem.entity.concrete.TestDrive;
import uniProject.carShowroomManagementSystem.entity.dto.TestDriveDto;

public interface TestDriveService extends BaseService<TestDrive>, AddService<TestDriveDto>{
	DataResult<List<TestDrive>> findByIsConfirmTrue();
	DataResult<List<TestDrive>> findByIsConfirmFalse();
	
	DataResult<List<TestDrive>> findBytestDate(LocalDate testDate);
	
	DataResult<List<TestDrive>> findAllByCustomer_Id(int customerId);
	DataResult<List<TestDrive>> findAllByCar_Id(int carId);
}
