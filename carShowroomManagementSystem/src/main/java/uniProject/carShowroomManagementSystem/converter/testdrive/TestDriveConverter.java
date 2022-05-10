package uniProject.carShowroomManagementSystem.converter.testdrive;

import uniProject.carShowroomManagementSystem.dto.CreateTestDriveRequestDto;
import uniProject.carShowroomManagementSystem.entity.TestDrive;

public interface TestDriveConverter {

	TestDrive toTestDrive(CreateTestDriveRequestDto createTestDriveRequestDto);

}
