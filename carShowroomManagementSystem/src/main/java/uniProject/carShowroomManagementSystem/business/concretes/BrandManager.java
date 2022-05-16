package uniProject.carShowroomManagementSystem.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.BrandService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.brand.BrandConverter;
import uniProject.carShowroomManagementSystem.core.util.result.*;
import uniProject.carShowroomManagementSystem.dataAccess.BrandDao;
import uniProject.carShowroomManagementSystem.dto.brand.BrandResponseDto;
import uniProject.carShowroomManagementSystem.dto.brand.CreateBrandRequestDto;
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
	public DataResult<BrandResponseDto> get(int id) {
		Brand brand = getById(id).getData();
		if(brand == null) {
			return new ErrorDataResult<BrandResponseDto>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<BrandResponseDto>(brandConverter.toBrandResponseDto(brand), Messages.viewed);
	}

	@Override
	public List<BrandResponseDto> toBrandResponseDtoList(List<Brand> brands){
		List<BrandResponseDto> brandResponseDtos = new ArrayList<BrandResponseDto>();
		brands.forEach(brand -> {
			BrandResponseDto brandResponseDto = brandConverter.toBrandResponseDto(brand);
			brandResponseDtos.add(brandResponseDto);
		});
		return brandResponseDtos;
	}
	
	@Override
	public DataResult<List<BrandResponseDto>> getAll() {
		return new SuccessDataResult<List<BrandResponseDto>>(
				toBrandResponseDtoList(brandDao.findAll()), Messages.listed);
	}
	

	@Override
	public DataResult<List<BrandResponseDto>> findByName(String name) {
		return new SuccessDataResult<List<BrandResponseDto>>(
				toBrandResponseDtoList(brandDao.findByName(name)), Messages.listed);
	}

}
