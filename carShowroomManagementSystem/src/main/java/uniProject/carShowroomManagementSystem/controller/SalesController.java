package uniProject.carShowroomManagementSystem.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.SaleService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.car.CarResponseDto;
import uniProject.carShowroomManagementSystem.dto.sale.CreateSaleRequestDto;
import uniProject.carShowroomManagementSystem.dto.sale.SaleResponseDto;
import uniProject.carShowroomManagementSystem.entity.Sale;

@Validated
@RestController
@RequestMapping("/api/sales/")
@RequiredArgsConstructor
public class SalesController {
	
	private final SaleService saleService;

	@PostMapping("/")
	public Result add(@Valid @RequestBody CreateSaleRequestDto entity) {
		return saleService.add(entity);
	}

	@DeleteMapping("{id}")
	public Result delete(@PathVariable int id) {
		return saleService.delete(id);
	}

	@PutMapping
	public Result update(@RequestBody Sale entity) {
		return saleService.update(entity);
	}

	@GetMapping("getById")
	public DataResult<SaleResponseDto> getById(@RequestParam int id) {
		return saleService.get(id);
	}

	@GetMapping("getAll")
	public DataResult<List<SaleResponseDto>> getAll() {
		return saleService.getAll();
	}

	@GetMapping("findByIsConfirmTrue")
	public DataResult<List<SaleResponseDto>> findByIsConfirmTrue() {
		return saleService.findByIsConfirmTrue();
	}

	@GetMapping("findByIsConfirmFalse")
	public DataResult<List<SaleResponseDto>> findByIsConfirmFalse() {
		return saleService.findByIsConfirmFalse();
	}

	@GetMapping("findBySaleDate")
	public DataResult<List<SaleResponseDto>> findBySaleDate(@RequestParam
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saleDate) {
		return saleService.findBySaleDate(saleDate);
	}
	
	@GetMapping("findBySaleDateBetweenOrderBySaleCount")
	public DataResult<Set<CarResponseDto>> findBySaleDateBetweenOrderBySaleCount(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstSaleDate, 
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate lastSaleDate){
		return saleService.findBySaleDateBetweenOrderBySaleCount(firstSaleDate, lastSaleDate);
	}

	@GetMapping("findAllByCustomer_Id")
	public DataResult<List<SaleResponseDto>> findAllByCustomer_Id(@RequestParam int customerId) {
		return saleService.findAllByCustomer_Id(customerId);
	}

	@GetMapping("findByCar_Id")
	public DataResult<List<SaleResponseDto>> findByCar_Id(int carId) {
		return saleService.findByCar_Id(carId);
	}

	@PatchMapping("confirmSale/{saleId}")
	public Result confirmSale(@PathVariable int saleId) {
		return saleService.confirmSale(saleId);
	}
}
