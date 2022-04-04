package uniProject.carShowroomManagementSystem.api.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniProject.carShowroomManagementSystem.business.abstracts.SaleService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.core.utilities.results.Result;
import uniProject.carShowroomManagementSystem.entities.concretes.Car;
import uniProject.carShowroomManagementSystem.entities.concretes.Sale;
import uniProject.carShowroomManagementSystem.entities.dtos.SaleDto;

@RestController
@RequestMapping("/api/sales/")
public class SalesController {
	
	private SaleService saleService;
	
	@Autowired
	public SalesController(SaleService saleService) {
		super();
		this.saleService = saleService;
	}

	@PostMapping("add")
	public Result add(@RequestBody SaleDto entity) {
		return saleService.add(entity);
	}

	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return saleService.delete(id);
	}

	@PostMapping("update")
	public Result update(Sale entity) {
		return saleService.update(entity);
	}

	@GetMapping("getById")
	public DataResult<Sale> getById(@RequestParam int id) {
		return saleService.getById(id);
	}

	@GetMapping("getAll")
	public DataResult<List<Sale>> getAll() {
		return saleService.getAll();
	}

	@GetMapping("findByIsConfirmTrue")
	public DataResult<List<Sale>> findByIsConfirmTrue() {
		return saleService.findByIsConfirmTrue();
	}

	@GetMapping("findByIsConfirmFalse")
	public DataResult<List<Sale>> findByIsConfirmFalse() {
		return saleService.findByIsConfirmFalse();
	}

	@GetMapping("findBySaleDate")
	public DataResult<List<Sale>> findBySaleDate(@RequestParam
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saleDate) {
		return saleService.findBySaleDate(saleDate);
	}
	
	@GetMapping("findBySaleDateBetweenOrderBySaleCount")
	public DataResult<Set<Car>> findBySaleDateBetweenOrderBySaleCount(@RequestParam
			 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
	LocalDate firstSaleDate, @RequestParam 
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
	LocalDate lastSaleDate){
		return saleService.findBySaleDateBetweenOrderBySaleCount(firstSaleDate, lastSaleDate);
	}

	@GetMapping("findAllByCustomer_Id")
	public DataResult<List<Sale>> findAllByCustomer_Id(@RequestParam int customerId) {
		return saleService.findAllByCustomer_Id(customerId);
	}

	@GetMapping("findByCar_Id")
	public DataResult<List<Sale>> findByCar_Id(int carId) {
		return saleService.findByCar_Id(carId);
	}

	@PostMapping("confirmSale")
	public Result confirmSale(int saleId) {
		return saleService.confirmSale(saleId);
	}
}
