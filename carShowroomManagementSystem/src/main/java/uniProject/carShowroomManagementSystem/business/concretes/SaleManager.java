package uniProject.carShowroomManagementSystem.business.concretes;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.CarService;
import uniProject.carShowroomManagementSystem.business.abstracts.SaleService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.sale.SaleConverter;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessResult;
import uniProject.carShowroomManagementSystem.dataAccess.SaleDao;
import uniProject.carShowroomManagementSystem.dto.CreateSaleRequestDto;
import uniProject.carShowroomManagementSystem.entity.Car;
import uniProject.carShowroomManagementSystem.entity.Sale;

@Service
@RequiredArgsConstructor
public class SaleManager implements SaleService{
	
	private final SaleDao saleDao;
	private final CarService carService;
	private final SaleConverter saleConverter;
	

	@Override
	public Result add(CreateSaleRequestDto createSaleRequestDto) {
		Sale sale = saleConverter.toSale(createSaleRequestDto);
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
	public DataResult<List<Sale>> getAll() {
		return new SuccessDataResult<List<Sale>>(saleDao.findAll(), Messages.listed);
	}

	@Override
	public DataResult<List<Sale>> findByIsConfirmTrue() {
		return new SuccessDataResult<List<Sale>>(saleDao.findByIsConfirmTrue(), Messages.listed);
	}

	@Override
	public DataResult<List<Sale>> findByIsConfirmFalse() {
		return new SuccessDataResult<List<Sale>>(saleDao.findByIsConfirmFalse(), Messages.listed);
	}

	@Override
	public DataResult<List<Sale>> findBySaleDate(LocalDate saleDate) {
		return new SuccessDataResult<List<Sale>>(saleDao.findBySaleDate(saleDate), Messages.listed);
	}

	@Override
	public DataResult<List<Sale>> findAllByCustomer_Id(int customerId) {
		return new SuccessDataResult<List<Sale>>(saleDao.findAllByCustomer_Id(customerId), Messages.listed);
	}

	@Override
	public DataResult<List<Sale>> findByCar_Id(int carId) {
		return new SuccessDataResult<List<Sale>>(saleDao.findByCar_Id(carId), Messages.listed);
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
		
		carService.setSaleCount(sale.getCar().getId());
		
		saleDao.save(sale);
		return new SuccessResult(Messages.confirmedSale);
	}

	//belirli bir tarih araligindaki en cok satilan arabalari(artan sirada) goster
	@Override
	public DataResult<Set<Car>> findBySaleDateBetweenOrderBySaleCount(LocalDate firstSaleDate,
			LocalDate lastSaleDate) {
		List<Sale> sales = saleDao.findBySaleDateBetweenOrderByCar_SaleCount(firstSaleDate, lastSaleDate);
		Set<Car> cars = new HashSet<Car>();
		for(Sale s : sales) {
			cars.add(s.getCar());
		}
		return new SuccessDataResult<Set<Car>>(cars, Messages.listed);
	}




}
