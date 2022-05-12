package uniProject.carShowroomManagementSystem.dto.sale;

import java.time.LocalDate;

import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.GetDto;
import lombok.Getter;

@Getter
@Setter
public class SaleResponseDto implements GetDto{
	int id;
	private int carId;
	private int customerId;
	private LocalDate saleDate;
	private double price;
	private boolean isConfirm;
}
