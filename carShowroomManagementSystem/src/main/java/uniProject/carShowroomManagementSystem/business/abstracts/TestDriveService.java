package uniProject.carShowroomManagementSystem.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.CreateTestDriveRequestDto;
import uniProject.carShowroomManagementSystem.entity.TestDrive;

public interface TestDriveService extends BaseService<TestDrive>, AddService<CreateTestDriveRequestDto>{
	DataResult<List<TestDrive>> findByIsConfirmTrue();
	DataResult<List<TestDrive>> findByIsConfirmFalse();
	
	DataResult<List<TestDrive>> findBytestDate(LocalDate testDate);
	
	DataResult<List<TestDrive>> findAllByCustomer_Id(int customerId);
	DataResult<List<TestDrive>> findAllByCar_Id(int carId);
	
	Result confirmTestDrive(int testDriveId);
}
