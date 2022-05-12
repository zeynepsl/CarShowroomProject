package uniProject.carShowroomManagementSystem.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.CarService;
import uniProject.carShowroomManagementSystem.business.abstracts.CustomerService;
import uniProject.carShowroomManagementSystem.business.abstracts.SaleService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.car.CarConverter;
import uniProject.carShowroomManagementSystem.converter.sale.SaleConverter;
import uniProject.carShowroomManagementSystem.core.util.result.*;
import uniProject.carShowroomManagementSystem.dataAccess.SaleDao;
import uniProject.carShowroomManagementSystem.dto.car.CarResponseDto;
import uniProject.carShowroomManagementSystem.dto.sale.CreateSaleRequestDto;
import uniProject.carShowroomManagementSystem.dto.sale.SaleResponseDto;
import uniProject.carShowroomManagementSystem.entity.Car;
import uniProject.carShowroomManagementSystem.entity.Sale;

@Service
@RequiredArgsConstructor
public class SaleManager implements SaleService{
	
	private final SaleDao saleDao;
	private final CarService carService;
	private final SaleConverter saleConverter;
	private final CarConverter carConverter;
	private final CustomerService customerService;

	@Override
	public Result add(CreateSaleRequestDto createSaleRequestDto) {
		Sale sale = saleConverter.toSale(createSaleRequestDto);
		Car carOfSale = carService.getById(createSaleRequestDto.getCarId()).getData();
		sale.setCar(carOfSale); 
		sale.setCustomer(customerService.getById(createSaleRequestDto.getCustomerId()).getData());
		sale.setPrice(carOfSale.getPrice());
		saleDao.save(sale);
		return new SuccessResult(Messages.added);
	}

	@Override
	public Result delete(int id) {
		Sale sale = getById(id).getData();
		if(sale == null) {
			return new ErrorResult(Messages.isNotExist);
		}
		saleDao.deleteById(id);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public Result update(Sale entity) {
		saleDao.save(entity);
		return new SuccessResult(Messages.updated);
	}

	@Override
	public DataResult<Sale> getById(int id) {
		Sale sale = saleDao.findById(id).orElse(null);
		if(sale == null) {
			return new ErrorDataResult<Sale>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<Sale>(sale, Messages.viewed);
	}
	
	@Override
	public DataResult<SaleResponseDto> get(int id) {
		Sale sale = getById(id).getData();
		if(sale == null) {
			return new ErrorDataResult<SaleResponseDto>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<SaleResponseDto>(saleConverter.toSaleResponseDto(sale), Messages.viewed);
	}

	@Override
	public DataResult<List<SaleResponseDto>> getAll() {
		return new SuccessDataResult<List<SaleResponseDto>>(
				toSaleResponseDtoList(saleDao.findAll()), Messages.listed);
	}
	
	@Override
	public List<SaleResponseDto> toSaleResponseDtoList(List<Sale> sales){
		List<SaleResponseDto> saleResponseDtos = new ArrayList<SaleResponseDto>();
		sales.forEach(sale -> {
			SaleResponseDto saleResponseDto = saleConverter.toSaleResponseDto(sale);
			saleResponseDtos.add(saleResponseDto);
		});
		return saleResponseDtos;
	}

	@Override
	public DataResult<List<SaleResponseDto>> findByIsConfirmTrue() {
		return new SuccessDataResult<List<SaleResponseDto>>(
				toSaleResponseDtoList(saleDao.findByIsConfirmTrue()), Messages.listed);
	}

	@Override
	public DataResult<List<SaleResponseDto>> findByIsConfirmFalse() {
		return new SuccessDataResult<List<SaleResponseDto>>(
				toSaleResponseDtoList(saleDao.findByIsConfirmFalse()), Messages.listed);
	}

	@Override
	public DataResult<List<SaleResponseDto>> findBySaleDate(LocalDate saleDate) {
		return new SuccessDataResult<List<SaleResponseDto>>(
				toSaleResponseDtoList(saleDao.findBySaleDate(saleDate)), Messages.listed);
	}

	@Override
	public DataResult<List<SaleResponseDto>> findAllByCustomer_Id(int customerId) {
		return new SuccessDataResult<List<SaleResponseDto>>(
				toSaleResponseDtoList(saleDao.findAllByCustomer_Id(customerId)), Messages.listed);
	}

	@Override
	public DataResult<List<SaleResponseDto>> findByCar_Id(int carId) {
		return new SuccessDataResult<List<SaleResponseDto>>(
				toSaleResponseDtoList(saleDao.findByCar_Id(carId)), Messages.listed);
	}

	@Override
	public Result confirmSale(int saleId) {
		Sale sale = getById(saleId).getData();
		if(sale == null) {
			return new ErrorResult(Messages.isNotExist);
		}
		if(sale.isConfirm()) {
			return new ErrorResult(Messages.alreadyConfirmed);
		}
		sale.setConfirm(true);
		sale.setSaleDate(LocalDate.now());//yonetici satisi onayladiginda  satis tarihini  de guncelleniyor
		
		carService.setSaleCount(sale.getCar().getId());
		
		saleDao.save(sale);
		return new SuccessResult(Messages.confirmedSale);
	}

	//belirli bir tarih araligindaki en cok satilan arabalari(artan sirada) goster
	@Override
	public DataResult<Set<CarResponseDto>> findBySaleDateBetweenOrderBySaleCount(LocalDate firstSaleDate,
			LocalDate lastSaleDate) {
		List<Sale> sales = saleDao.findBySaleDateBetweenOrderByCar_SaleCount(firstSaleDate, lastSaleDate);
		Set<Car> cars = new HashSet<Car>();
		for(Sale s : sales) {
			cars.add(s.getCar());
		}
		
		Set<CarResponseDto> carResponseDtos = carConverter.toCarResponseDtoSet(cars);
		
		return new SuccessDataResult<Set<CarResponseDto>>(carResponseDtos, Messages.listed);
	}




}
