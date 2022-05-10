package uniProject.carShowroomManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uniProject.carShowroomManagementSystem.core.entity.Dto;
import uniProject.carShowroomManagementSystem.core.entity.User;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto extends User implements Dto{
	private String firstName;
	private String lastName;
	private String phoneNUmber;
}
