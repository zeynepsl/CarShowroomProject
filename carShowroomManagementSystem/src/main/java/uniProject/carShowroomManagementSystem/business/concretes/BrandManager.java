package uniProject.carShowroomManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.BrandService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.brand.BrandConverter;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessResult;
import uniProject.carShowroomManagementSystem.dataAccess.BrandDao;
import uniProject.carShowroomManagementSystem.dto.CreateBrandRequestDto;
import uniProject.carShowroomManagementSystem.entity.Brand;

@Service
@RequiredArgsConstructor
public class BrandManager implements BrandService{

	private final BrandDao brandDao;
	private final BrandConverter brandConverter;

	@Override
	public Result add(CreateBrandRequestDto createBrandRequestDto) {
		Brand brand = brandConverter.toBrand(createBrandRequestDto);
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
