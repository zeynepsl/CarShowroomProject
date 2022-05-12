package uniProject.carShowroomManagementSystem.dto.testdrive;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.CreateDto;

@Getter
@Setter
@Validated
public class CreateTestDriveRequestDto implements CreateDto{
	
	@NotNull(message = "car id of testDrive cannot be null")
	private int carId;
	
	@NotNull(message = "customer id of testDrive cannot be null")
	private int customerId;
	
	@NotNull(message = "testDate of testDrive cannot be null")
	private LocalDate testDate;
}
