package uniProject.carShowroomManagementSystem.business.abstracts;

import java.time.LocalTime;
import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.entities.concretes.Customer;

public interface CustomerService extends BaseService<Customer>{
	DataResult<List<Customer>> findByBirthDateAfter(LocalTime birthDate);
	DataResult<List<Customer>> findByBirthDateBefore(LocalTime birthDate);
}
