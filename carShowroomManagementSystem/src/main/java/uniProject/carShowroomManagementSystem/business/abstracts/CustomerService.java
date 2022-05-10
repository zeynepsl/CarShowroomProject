package uniProject.carShowroomManagementSystem.business.abstracts;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.entity.concrete.Customer;
import uniProject.carShowroomManagementSystem.dto.CustomerDto;

public interface CustomerService extends BaseService<Customer>, AddService<CustomerDto>{
}
