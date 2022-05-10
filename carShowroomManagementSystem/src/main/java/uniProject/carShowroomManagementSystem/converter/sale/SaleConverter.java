package uniProject.carShowroomManagementSystem.converter.sale;

import uniProject.carShowroomManagementSystem.dto.CreateSaleRequestDto;
import uniProject.carShowroomManagementSystem.entity.Sale;

public interface SaleConverter {

	Sale toSale(CreateSaleRequestDto createSaleRequestDto);

}
