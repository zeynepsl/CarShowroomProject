package uniProject.carShowroomManagementSystem.converter.testdrive;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.CarService;
import uniProject.carShowroomManagementSystem.business.abstracts.CustomerService;
import uniProject.carShowroomManagementSystem.dto.CreateTestDriveRequestDto;
import uniProject.carShowroomManagementSystem.entity.TestDrive;

@Component
@RequiredArgsConstructor
public class TestDriveConverterImpl implements TestDriveConverter{
	private final CustomerService customerService;
	private final CarService carService;
	
	@Override
	public TestDrive toTestDrive(CreateTestDriveRequestDto createTestDriveRequestDto) {
		TestDrive testDrive = new TestDrive();
		testDrive.setCar(carService.getById(createTestDriveRequestDto.getCarId()).getData());
		testDrive.setCustomer(customerService.getById(createTestDriveRequestDto.getCustomerId()).getData());
		testDrive.setTestDate(createTestDriveRequestDto.getTestDate());
		testDrive.setConfirm(false);
		return testDrive;
	}
}
