package uniProject.carShowroomManagementSystem.converter.sale;

import uniProject.carShowroomManagementSystem.dto.sale.CreateSaleRequestDto;
import uniProject.carShowroomManagementSystem.dto.sale.SaleResponseDto;
import uniProject.carShowroomManagementSystem.entity.Sale;

public interface SaleConverter {

	Sale toSale(CreateSaleRequestDto createSaleRequestDto);

	SaleResponseDto toSaleResponseDto(Sale sale);

}
