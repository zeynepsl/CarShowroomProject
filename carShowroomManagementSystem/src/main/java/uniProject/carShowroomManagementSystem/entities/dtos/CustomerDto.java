package uniProject.carShowroomManagementSystem.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uniProject.carShowroomManagementSystem.core.entities.Dto;
import uniProject.carShowroomManagementSystem.core.entities.User;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto extends User implements Dto{
	private String firstName;
	private String lastName;
	private String phoneNUmber;
}
