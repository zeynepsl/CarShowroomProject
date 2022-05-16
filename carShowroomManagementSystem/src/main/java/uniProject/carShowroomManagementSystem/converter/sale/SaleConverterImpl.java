package uniProject.carShowroomManagementSystem.converter.sale;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.dto.sale.CreateSaleRequestDto;
import uniProject.carShowroomManagementSystem.dto.sale.SaleResponseDto;
import uniProject.carShowroomManagementSystem.entity.Sale;

@Component
@RequiredArgsConstructor
public class SaleConverterImpl implements SaleConverter{
	
	@Override
	public Sale toSale(CreateSaleRequestDto createSaleRequestDto) {
		Sale sale = new Sale();
		sale.setConfirm(false);//kullanici alma islemini yapti, fakat daha yonetcicnin onyalamsı gerek
		return sale;
	}
	
	@Override
	public SaleResponseDto toSaleResponseDto(Sale sale) {
		SaleResponseDto saleResponseDto = new SaleResponseDto();
		saleResponseDto.setId(sale.getId());
		saleResponseDto.setCarId(sale.getCar().getId());
		saleResponseDto.setConfirm(sale.isConfirm());
		saleResponseDto.setCustomerId(sale.getCustomer().getId());
		saleResponseDto.setPrice(sale.getPrice());
		saleResponseDto.setSaleDate(sale.getSaleDate());
		return saleResponseDto;
	}
}
