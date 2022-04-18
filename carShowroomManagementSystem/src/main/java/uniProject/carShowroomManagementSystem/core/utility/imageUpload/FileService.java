package uniProject.carShowroomManagementSystem.core.utility.imageUpload;


import org.springframework.web.multipart.MultipartFile;

import uniProject.carShowroomManagementSystem.core.utility.result.DataResult;



public interface FileService {
	DataResult<?> fileUpload(MultipartFile file);
}
