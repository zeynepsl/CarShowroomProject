package uniProject.carShowroomManagementSystem.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.Dto;

@Getter
@Setter
public class CreateTestDriveRequestDto implements Dto{
	private int carId;
	private int customerId;
	
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm")
	private LocalDate testDate;
}
