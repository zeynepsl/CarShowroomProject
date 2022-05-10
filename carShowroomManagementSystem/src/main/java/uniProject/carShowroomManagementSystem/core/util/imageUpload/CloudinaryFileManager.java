package uniProject.carShowroomManagementSystem.core.util.imageUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessDataResult;



@Service
public class CloudinaryFileManager implements FileService{

	private Cloudinary cloudinary;
	
	public CloudinaryFileManager() {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				 "cloud_name", "df27kkeid",
				  "api_key", "685317151961499",
				  "api_secret", "a_oojDY8FjyewynzFMZ8dFEh8zg"));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public DataResult<Map> fileUpload(MultipartFile file) {
			Map<String, String> resultMap = null;
			try {
				resultMap = (Map<String, String>) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new SuccessDataResult<Map>(resultMap);
	}
	

}
