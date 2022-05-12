package uniProject.carShowroomManagementSystem.converter.testdrive;

import uniProject.carShowroomManagementSystem.dto.testdrive.CreateTestDriveRequestDto;
import uniProject.carShowroomManagementSystem.dto.testdrive.TestDriveResponseDto;
import uniProject.carShowroomManagementSystem.entity.TestDrive;

public interface TestDriveConverter {

	TestDrive toTestDrive(CreateTestDriveRequestDto createTestDriveRequestDto);

	TestDriveResponseDto toTestDriveResponseDto(TestDrive testDrive);

}
