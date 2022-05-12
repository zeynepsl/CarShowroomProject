package uniProject.carShowroomManagementSystem.converter.testdrive;

import org.springframework.stereotype.Component;

import uniProject.carShowroomManagementSystem.dto.testdrive.CreateTestDriveRequestDto;
import uniProject.carShowroomManagementSystem.dto.testdrive.TestDriveResponseDto;
import uniProject.carShowroomManagementSystem.entity.TestDrive;

@Component
public class TestDriveConverterImpl implements TestDriveConverter{
	
	@Override
	public TestDrive toTestDrive(CreateTestDriveRequestDto createTestDriveRequestDto) {
		TestDrive testDrive = new TestDrive();
		testDrive.setTestDate(createTestDriveRequestDto.getTestDate());
		testDrive.setConfirm(false);
		return testDrive;
	}
	
	@Override
	public TestDriveResponseDto toTestDriveResponseDto(TestDrive testDrive) {
		TestDriveResponseDto testDriveResponseDto = new TestDriveResponseDto();
		testDriveResponseDto.setId(testDrive.getId());
		testDriveResponseDto.setCarId(testDrive.getCar().getId());
		testDriveResponseDto.setConfirm(testDrive.isConfirm());
		testDriveResponseDto.setCustomerId(testDrive.getCustomer().getId());
		testDriveResponseDto.setTestDate(testDrive.getTestDate());
		return testDriveResponseDto;
	}
}
