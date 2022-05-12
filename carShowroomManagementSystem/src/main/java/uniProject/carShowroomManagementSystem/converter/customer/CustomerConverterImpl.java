package uniProject.carShowroomManagementSystem.converter.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.converter.sale.SaleConverter;
import uniProject.carShowroomManagementSystem.converter.testdrive.TestDriveConverter;
import uniProject.carShowroomManagementSystem.dto.customer.CreateCustomerRequestDto;
import uniProject.carShowroomManagementSystem.dto.customer.CustomerResponseDto;
import uniProject.carShowroomManagementSystem.dto.sale.SaleResponseDto;
import uniProject.carShowroomManagementSystem.dto.testdrive.TestDriveResponseDto;
import uniProject.carShowroomManagementSystem.entity.Customer;

@Component
@RequiredArgsConstructor
public class CustomerConverterImpl implements CustomerConverter{
	
	private final SaleConverter saleConverter;
	private final TestDriveConverter testDriveConverter;
	@Override
	public Customer toCustomer(CreateCustomerRequestDto createCustomerRequestDto) {
		Customer customer = new Customer();
		customer.setFirstName(createCustomerRequestDto.getFirstName());
		customer.setLastName(createCustomerRequestDto.getLastName());
		customer.setUsername(createCustomerRequestDto.getUsername());
		customer.setEmail(createCustomerRequestDto.getEmail());
		customer.setPassword(createCustomerRequestDto.getPassword());
		customer.setPhoneNumber(createCustomerRequestDto.getPhoneNumber());
		return customer;
	}
	
	@Override
	public CustomerResponseDto toCustomerResponseDto(Customer customer) {
		CustomerResponseDto customerResponseDto = new CustomerResponseDto();
		customerResponseDto.setId(customer.getId());
		customerResponseDto.setFirstName(customer.getFirstName());
		customerResponseDto.setLastName(customer.getLastName());
		customerResponseDto.setPhoneNumber(customer.getPhoneNumber());
		customerResponseDto.setEmail(customer.getEmail());
		customerResponseDto.setUserName(customer.getUsername());
		
		List<SaleResponseDto> saleResponseDtos = new ArrayList<SaleResponseDto>();
		customer.getSales().forEach(sale -> {
			saleResponseDtos.add(saleConverter.toSaleResponseDto(sale));
		});
		customerResponseDto.setSales(saleResponseDtos);
		
		List<TestDriveResponseDto> testDriveResponseDtos = new ArrayList<TestDriveResponseDto>();
		customer.getTestDrives().forEach(testDrive -> {
			testDriveResponseDtos.add(testDriveConverter.toTestDriveResponseDto(testDrive));
		});
		customerResponseDto.setTestDrives(testDriveResponseDtos);//test drive response dto
		return customerResponseDto;
	}
}
