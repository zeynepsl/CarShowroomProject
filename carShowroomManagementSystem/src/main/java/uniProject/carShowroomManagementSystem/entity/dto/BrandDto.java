package uniProject.carShowroomManagementSystem.entity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uniProject.carShowroomManagementSystem.core.entity.Dto;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BrandDto implements Dto{

	@NotNull
	String name;
}
