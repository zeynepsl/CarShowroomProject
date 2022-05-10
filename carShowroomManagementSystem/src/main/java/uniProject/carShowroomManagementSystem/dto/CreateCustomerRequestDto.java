package uniProject.carShowroomManagementSystem.dto;

import lombok.*;
import uniProject.carShowroomManagementSystem.core.entity.Dto;
import uniProject.carShowroomManagementSystem.core.entity.User;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequestDto extends User implements Dto{
	private String firstName;
	private String lastName;
	private String phoneNumber;
}
