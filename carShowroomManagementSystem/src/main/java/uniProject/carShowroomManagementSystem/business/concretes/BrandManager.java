package uniProject.carShowroomManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniProject.carShowroomManagementSystem.business.abstracts.BrandService;
import uniProject.carShowroomManagementSystem.business.constants.Messages;
import uniProject.carShowroomManagementSystem.core.utility.result.DataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.ErrorDataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.ErrorResult;
import uniProject.carShowroomManagementSystem.core.utility.result.Result;
import uniProject.carShowroomManagementSystem.core.utility.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.SuccessResult;
import uniProject.carShowroomManagementSystem.dataAccess.abstracts.BrandDao;
import uniProject.carShowroomManagementSystem.entity.concrete.Brand;
import uniProject.carShowroomManagementSystem.dto.BrandDto;

@Service
public class BrandManager implements BrandService{

	private BrandDao brandDao;
	
	@Autowired
	public BrandManager(BrandDao brandDao) {
		this.brandDao = brandDao;
	}

	@Override
	public Result add(BrandDto entity) {
		Brand brand = new Brand();
		brand.setName(entity.getName());
		brandDao.save(brand);
		return new SuccessResult(Messages.added);
	}

	@Override
	public Result delete(int id) {
		Brand brand = getById(id).getData();
		if(brand == null) {
			return new ErrorResult(Messages.isNotExist);
		}
		brandDao.deleteById(id);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public Result update(Brand entity) {
		brandDao.save(entity);
		return new SuccessResult(Messages.updated);
	}

	@Override
	public DataResult<Brand> getById(int id) {
		Brand brand = brandDao.findById(id).orElse(null);
		if(brand == null) {
			return new ErrorDataResult<Brand>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<Brand>(brand, Messages.viewed);
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		return new SuccessDataResult<List<Brand>>(brandDao.findAll(), Messages.listed);
	}

	@Override
	public DataResult<List<Brand>> findByName(String name) {
		return new SuccessDataResult<List<Brand>>(brandDao.findByName(name), Messages.listed);
	}

}
