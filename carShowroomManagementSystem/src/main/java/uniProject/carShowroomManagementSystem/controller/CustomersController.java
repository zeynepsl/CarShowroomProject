package uniProject.carShowroomManagementSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.CustomerService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.CreateCustomerRequestDto;
import uniProject.carShowroomManagementSystem.entity.Customer;

@RestController
@RequestMapping("/api/customers/")
@RequiredArgsConstructor
public class CustomersController {
	private final CustomerService customerService;
	
	@PostMapping("/")
	public Result add(@RequestBody CreateCustomerRequestDto entity) {
		return customerService.add(entity);
	}
	
	@DeleteMapping("{id}")
	public Result delete(@PathVariable int id) {
		return customerService.delete(id);
	}

	@GetMapping("{id}")
	public DataResult<Customer> getById(@PathVariable int id) {
		return customerService.getById(id);
	}

	@GetMapping("getAll")
	public DataResult<List<Customer>> getAll() {
		return customerService.getAll();
	}
}
