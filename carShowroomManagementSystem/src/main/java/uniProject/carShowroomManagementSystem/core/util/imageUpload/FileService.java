package uniProject.carShowroomManagementSystem.core.util.imageUpload;


import org.springframework.web.multipart.MultipartFile;

import uniProject.carShowroomManagementSystem.core.util.result.DataResult;

public interface FileService {
	DataResult<?> fileUpload(MultipartFile file);
}
