package uniProject.carShowroomManagementSystem.converter.testdrive;

import org.springframework.stereotype.Component;

import uniProject.carShowroomManagementSystem.dto.CreateTestDriveRequestDto;
import uniProject.carShowroomManagementSystem.entity.TestDrive;

@Component
public class TestDriveConverterImpl implements TestDriveConverter{
	@Override
	public TestDrive toTestDrive(CreateTestDriveRequestDto createTestDriveRequestDto) {
		TestDrive testDrive = new TestDrive();
		testDrive.setConfirm(false);
		return testDrive;
	}
}
