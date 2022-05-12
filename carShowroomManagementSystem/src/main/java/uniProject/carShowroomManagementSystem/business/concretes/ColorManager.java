package uniProject.carShowroomManagementSystem.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.ColorService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.color.ColorConverter;
import uniProject.carShowroomManagementSystem.core.util.result.*;
import uniProject.carShowroomManagementSystem.dataAccess.ColorDao;
import uniProject.carShowroomManagementSystem.dto.color.ColorResponseDto;
import uniProject.carShowroomManagementSystem.dto.color.CreateColorRequestDto;
import uniProject.carShowroomManagementSystem.entity.Color;

@Service
@RequiredArgsConstructor
public class ColorManager implements ColorService{

	private final ColorDao colorDao;
	private final ColorConverter colorConverter;

	@Override
	public Result add(CreateColorRequestDto createColorRequestDto) {
		Color color = colorConverter.toColor(createColorRequestDto);
		colorDao.save(color);
		return new SuccessResult(Messages.added);
	}

	@Override
	public Result delete(int id) {
		Color color = getById(id).getData();
		if(color == null) {
			return new ErrorResult(Messages.isNotExist);
		}
		colorDao.deleteById(id);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public Result update(Color entity) {
		colorDao.save(entity);
		return new SuccessResult(Messages.updated);
	}

	@Override
	public DataResult<Color> getById(int id) {
		Color color = colorDao.findById(id).orElse(null);
		if(color == null) {
			return new ErrorDataResult<Color>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<Color>(color, Messages.viewed);
	}
	
	@Override
	public DataResult<ColorResponseDto> get(int id) {
		Color color = getById(id).getData();
		if(color == null) {
			return new ErrorDataResult<ColorResponseDto>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<ColorResponseDto>(colorConverter.toColorResponseDto(color), Messages.viewed);
	}
	
	@Override
	public List<ColorResponseDto> toColorResponseDtoLis(List<Color> colors){
		List<ColorResponseDto> colorResponseDtos = new ArrayList<ColorResponseDto>();
		colors.forEach(color -> {
			ColorResponseDto colorResponseDto = colorConverter.toColorResponseDto(color);
			colorResponseDtos.add(colorResponseDto);
		});
		return colorResponseDtos;
	}
	
	@Override
	public DataResult<List<ColorResponseDto>> getAll() {
		return new SuccessDataResult<List<ColorResponseDto>>(
				toColorResponseDtoLis(colorDao.findAll()), Messages.listed);
	}

	@Override
	public DataResult<List<ColorResponseDto>> findByName(String name) {
		return new SuccessDataResult<List<ColorResponseDto>>(
				toColorResponseDtoLis(colorDao.findByName(name)), Messages.listed);
	}

}
