package uniProject.carShowroomManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniProject.carShowroomManagementSystem.business.abstracts.CustomerService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.core.utilities.results.Result;
import uniProject.carShowroomManagementSystem.entities.concretes.Customer;
import uniProject.carShowroomManagementSystem.entities.dtos.CustomerDto;

@RestController
@RequestMapping("/api/customers/")
public class CustomersController {
	private CustomerService customerService;

	@Autowired
	public CustomersController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody CustomerDto entity) {
		return customerService.add(entity);
	}
	
	@PostMapping("delete")
	public Result delete(int id) {
		return customerService.delete(id);
	}

	@GetMapping("getById")
	public DataResult<Customer> getById(int id) {
		return customerService.getById(id);
	}

	@GetMapping("getAll")
	public DataResult<List<Customer>> getAll() {
		return customerService.getAll();
	}
}
