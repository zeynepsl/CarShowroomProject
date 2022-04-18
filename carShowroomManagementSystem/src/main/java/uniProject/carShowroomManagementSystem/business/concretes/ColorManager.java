package uniProject.carShowroomManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniProject.carShowroomManagementSystem.business.abstracts.ColorService;
import uniProject.carShowroomManagementSystem.business.constants.Messages;
import uniProject.carShowroomManagementSystem.core.utility.result.DataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.ErrorDataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.ErrorResult;
import uniProject.carShowroomManagementSystem.core.utility.result.Result;
import uniProject.carShowroomManagementSystem.core.utility.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.SuccessResult;
import uniProject.carShowroomManagementSystem.dataAccess.abstracts.ColorDao;
import uniProject.carShowroomManagementSystem.entity.concrete.Color;
import uniProject.carShowroomManagementSystem.entity.dto.ColorDto;

@Service
public class ColorManager implements ColorService{

	private ColorDao colorDao;
	
	@Autowired
	public ColorManager(ColorDao colorDao) {
		this.colorDao = colorDao;
	}

	@Override
	public Result add(ColorDto entity) {
		Color color = new Color();
		color.setName(entity.getName());
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
