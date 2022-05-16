package uniProject.carShowroomManagementSystem.business;

import java.time.LocalDate;
import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.business.GetAllService;
import uniProject.carShowroomManagementSystem.core.business.GetService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.testdrive.CreateTestDriveRequestDto;
import uniProject.carShowroomManagementSystem.dto.testdrive.TestDriveResponseDto;
import uniProject.carShowroomManagementSystem.entity.TestDrive;

public interface TestDriveService extends BaseService<TestDrive>, 
                                          AddService<CreateTestDriveRequestDto>, 
                                          GetService<TestDriveResponseDto>, GetAllService<List<TestDriveResponseDto>>{
	
	List<TestDriveResponseDto> toTestDriveResponseDtoList(List<TestDrive> testDrives);
	
	DataResult<List<TestDriveResponseDto>> findByIsConfirmTrue();
	DataResult<List<TestDriveResponseDto>> findByIsConfirmFalse();
	
	DataResult<List<TestDriveResponseDto>> findBytestDate(LocalDate testDate);
	
	DataResult<List<TestDriveResponseDto>> findAllByCustomer_Id(int customerId);
	DataResult<List<TestDriveResponseDto>> findAllByCar_Id(int carId);
	
	Result confirmTestDrive(int testDriveId);
}
