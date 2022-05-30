package uniProject.carShowroomManagementSystem.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.CarImageService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.carimage.CarImageConverter;
import uniProject.carShowroomManagementSystem.core.util.imageUpload.FileService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessResult;
import uniProject.carShowroomManagementSystem.dataAccess.CarImageDao;
import uniProject.carShowroomManagementSystem.dto.carimage.CarImageResponseDto;
import uniProject.carShowroomManagementSystem.dto.carimage.CreateCarImageDto;
import uniProject.carShowroomManagementSystem.entity.CarImage;

@Service
@RequiredArgsConstructor
public class CarImageManager implements CarImageService{
	
	private final CarImageDao carImageDao;
	private final CarImageConverter carImageConverter;
	private final FileService fileService;

	@Override
	public Result add(CreateCarImageDto createCarImageDto) {
		CarImage carImage = carImageConverter.toCarImage(createCarImageDto);
		carImageDao.save(carImage);
		return new SuccessResult(Messages.added);
	}
	
	@Override
	public Result delete(int id) {
		CarImage carImage = getById(id).getData();
		if(carImage == null) {
			return new ErrorResult(Messages.isNotExist);
		}
		carImageDao.delete(carImage);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public Result update(CarImage entity) {
		carImageDao.save(entity);
		return new SuccessResult(Messages.updated);
	}

	@Override
	public DataResult<CarImage> getById(int id) {
		CarImage carImage = carImageDao.findById(id).orElse(null);
		if(carImage == null) {
			return new ErrorDataResult<CarImage>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<CarImage>(carImage, Messages.viewed);
	}

	@Override
	public DataResult<CarImageResponseDto> get(int id) {
		CarImage carImage = getById(id).getData();
		if(carImage == null) {
			return new ErrorDataResult<CarImageResponseDto>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<CarImageResponseDto>(
				carImageConverter.toCarImageResponseDto(carImage), Messages.viewed);
	}

	@Override
	public DataResult<List<CarImageResponseDto>> getAll() {
		List<CarImageResponseDto> carImageResponseDtos = new ArrayList<CarImageResponseDto>();
		carImageDao.findAll().forEach(carimage -> {
			CarImageResponseDto carImageResponseDto = carImageConverter.toCarImageResponseDto(carimage);
			carImageResponseDtos.add(carImageResponseDto);
		});
		return new SuccessDataResult<List<CarImageResponseDto>>(carImageResponseDtos, Messages.listed);
	}
	
	@Override
	public Result addWithEntity(CarImage carImage) {
		carImageDao.save(carImage);
		return new SuccessResult(Messages.added);
	}
	
	@Override
	public void upload(CarImage carImage, MultipartFile imageFile) {

		Map<String,String> uploadImage = (Map<String, String>) this.fileService.fileUpload(imageFile).getData();
		carImage.setUrl(uploadImage.get("url"));
		//this.candidateImageCVDao.save(imageCV);
		//return new SuccessResult("resim eklendi");
		addWithEntity(carImage);
	}
	
}
