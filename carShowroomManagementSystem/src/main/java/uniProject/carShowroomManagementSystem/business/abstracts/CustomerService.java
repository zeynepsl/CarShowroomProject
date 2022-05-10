package uniProject.carShowroomManagementSystem.business.abstracts;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.dto.CreateCustomerRequestDto;
import uniProject.carShowroomManagementSystem.entity.Customer;

public interface CustomerService extends BaseService<Customer>, AddService<CreateCustomerRequestDto>{
}
