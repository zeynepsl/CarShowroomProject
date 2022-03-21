package uniProject.carShowroomManagementSystem.core.utilities.imageUpload;


import org.springframework.web.multipart.MultipartFile;

import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;


public interface FileService {
	DataResult<?> fileUpload(MultipartFile file);
}
