package uniProject.carShowroomManagementSystem.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppWebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String reportPath = uploadPath("./generated-reports");

        registry.addResourceHandler("/generated-reports/**")
                .addResourceLocations("file:/"+reportPath+"/");
    }

    private String uploadPath(String directory){
        Path uploadDirPath = Paths.get(directory);
        return uploadDirPath.toFile().getAbsolutePath();
    }
}
