package uniProject.carShowroomManagementSystem.core.util.imageUpload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
    
    
}
