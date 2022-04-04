package uniProject.carShowroomManagementSystem.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uniProject.carShowroomManagementSystem.core.entities.Dto;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BrandDto implements Dto{
	String name;
}
