package uniProject.carShowroomManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.ColorService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.color.ColorConverter;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessResult;
import uniProject.carShowroomManagementSystem.dataAccess.ColorDao;
import uniProject.carShowroomManagementSystem.dto.CreateColorRequestDto;
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
	public DataResult<List<Color>> getAll() {
		return new SuccessDataResult<List<Color>>(colorDao.findAll(), Messages.listed);
	}

	@Override
	public DataResult<List<Color>> findByName(String name) {
		return new SuccessDataResult<List<Color>>(colorDao.findByName(name), Messages.listed);
	}

}
