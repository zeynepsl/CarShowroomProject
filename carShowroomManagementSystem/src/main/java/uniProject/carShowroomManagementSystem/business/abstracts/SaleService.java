package uniProject.carShowroomManagementSystem.business.abstracts;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import uniProject.carShowroomManagementSystem.core.business.*;

import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.car.CarResponseDto;
import uniProject.carShowroomManagementSystem.dto.sale.CreateSaleRequestDto;
import uniProject.carShowroomManagementSystem.dto.sale.SaleResponseDto;
import uniProject.carShowroomManagementSystem.entity.Sale;

public interface SaleService extends BaseService<Sale>, 
                                     AddService<CreateSaleRequestDto>, 
                                     GetService<SaleResponseDto>, GetAllService<List<SaleResponseDto>>{
	
	List<SaleResponseDto> toSaleResponseDtoList(List<Sale> sales);
	
	DataResult<List<SaleResponseDto>> findByIsConfirmTrue();
	DataResult<List<SaleResponseDto>> findByIsConfirmFalse();
	
	DataResult<List<SaleResponseDto>> findBySaleDate(LocalDate saleDate);
	DataResult<Set<CarResponseDto>> findBySaleDateBetweenOrderBySaleCount(LocalDate firstSaleDate, LocalDate lastSaleDate);
	
	DataResult<List<SaleResponseDto>> findAllByCustomer_Id(int customerId);
	DataResult<List<SaleResponseDto>> findByCar_Id(int carId);
	
	Result confirmSale(int saleId);
}
