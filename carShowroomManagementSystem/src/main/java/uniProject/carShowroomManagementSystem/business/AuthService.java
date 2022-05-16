package uniProject.carShowroomManagementSystem.business;

import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.auth.LoginDto;
import uniProject.carShowroomManagementSystem.dto.customer.CreateCustomerRequestDto;
import uniProject.carShowroomManagementSystem.dto.customer.CustomerResponseDto;

public interface AuthService {
	public DataResult<CustomerResponseDto> login(LoginDto loginDto);

}
