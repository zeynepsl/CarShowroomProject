package uniProject.carShowroomManagementSystem.converter.sale;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.CarService;
import uniProject.carShowroomManagementSystem.business.abstracts.CustomerService;
import uniProject.carShowroomManagementSystem.dto.CreateSaleRequestDto;
import uniProject.carShowroomManagementSystem.entity.Sale;

@Component
@RequiredArgsConstructor
public class SaleConverterImpl implements SaleConverter{
	private final CarService carService;
	private final CustomerService customerService;
	
	@Override
	public Sale toSale(CreateSaleRequestDto createSaleRequestDto) {
		Sale sale = new Sale();
		sale.setConfirm(false);//kullanici alma islemini yapti, fakat daha yonetcicnin onyalamsı gerek
		sale.setSaleDate(LocalDate.now());
		
		sale.setCar(carService.getById(createSaleRequestDto.getCarId()).getData()); 
		sale.setCustomer(customerService.getById(createSaleRequestDto.getCustomerId()).getData());
		
		return sale;
	}
}
