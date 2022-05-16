package uniProject.carShowroomManagementSystem.dto.customer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.*;
import uniProject.carShowroomManagementSystem.core.entity.CreateDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class CreateCustomerRequestDto implements CreateDto{
	
	@NotBlank(message = "firstName must not be null and its length must be greater than zero. ")
	private String firstName;
	
	@NotBlank(message = "lastName must not be null and its length must be greater than zero. ")
	private String lastName;
	
	@NotBlank(message = "email must not be null and its length must be greater than zero.")
	@Email
	private String email;
	
	@NotBlank(message = "firstName must not be null and its length must be greater than zero.")
	private String password;
	
	@NotEmpty(message = "firstName must not be null and its length must be greater than zero.")
	private String phoneNumber;
}
