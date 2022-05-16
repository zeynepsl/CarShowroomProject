package uniProject.carShowroomManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.CustomerService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.customer.CreateCustomerRequestDto;
import uniProject.carShowroomManagementSystem.dto.customer.CustomerResponseDto;

@Validated
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomersController {
	private final CustomerService customerService;
	
	@PostMapping("/")
	public Result add(@Valid @RequestBody CreateCustomerRequestDto entity) {
		return customerService.add(entity);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return customerService.delete(id);
	}

	@GetMapping("/{id}")
	public DataResult<CustomerResponseDto> getById(@PathVariable int id) {
		return customerService.get(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<CustomerResponseDto>> getAll() {
		return customerService.getAll();
	}
	
	@GetMapping("/")
	public DataResult<CustomerResponseDto> findByEmail(@RequestParam String email){
		return customerService.findByEmail(email);
	}
}
