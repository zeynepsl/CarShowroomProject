package uniProject.carShowroomManagementSystem.business.abstracts;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.entities.concretes.Customer;
import uniProject.carShowroomManagementSystem.entities.dtos.CustomerDto;

public interface CustomerService extends BaseService<Customer>, AddService<CustomerDto>{
}
