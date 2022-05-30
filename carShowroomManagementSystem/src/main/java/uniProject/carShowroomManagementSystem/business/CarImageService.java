package uniProject.carShowroomManagementSystem.business;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.business.GetAllService;
import uniProject.carShowroomManagementSystem.core.business.GetService;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.carimage.CarImageResponseDto;
import uniProject.carShowroomManagementSystem.dto.carimage.CreateCarImageDto;
import uniProject.carShowroomManagementSystem.entity.CarImage;

public interface CarImageService extends BaseService<CarImage>,
                                         AddService<CreateCarImageDto>,
                                         GetService<CarImageResponseDto>, GetAllService<List<CarImageResponseDto>>{

	void upload(CarImage carImage, MultipartFile imageFile);
	Result addWithEntity(CarImage carImage);

}
