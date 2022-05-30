package uniProject.carShowroomManagementSystem.business.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import uniProject.carShowroomManagementSystem.dataAccess.SaleDao;
import uniProject.carShowroomManagementSystem.entity.Sale;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
	private final SaleDao saleDao;

	@Override
	public JasperPrint getJasperPrint(List<Sale> sales, String resourceLocation)
			throws FileNotFoundException, JRException {
		File file = ResourceUtils.getFile(resourceLocation);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(sales);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Zeynep");

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		return jasperPrint;
	}
	
	@Override
	public String generate2() throws JRException, IOException {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Zeynep");
		parameters.put("saleData", new JRBeanCollectionDataSource(findAllSale()));
		JasperPrint jasperPrint = 
				JasperFillManager.fillReport
				(
						JasperCompileManager.compileReport(
						ResourceUtils.getFile("classpath:sales.jrxml")
						     .getAbsolutePath())
						, parameters
						, new JREmptyDataSource()
				);
		//(jasperReport, parameters, dataSource);
		HttpHeaders headers = new HttpHeaders();
		//set the PDF format
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("filename", "sales-details.pdf");
		//create the report in PDF format
		OutputStream out = new FileOutputStream("sales-details.pdf");
		out.write(JasperExportManager.exportReportToPdf(jasperPrint));
		
		
	
		// generate the report and save it in the just created folder
	     JasperExportManager.exportReportToPdfFile(jasperPrint, "sales-deatils");
	     return "/" + "sales.pdf";
		//return new ResponseEntity<byte[]>
			//	(JasperExportManager.exportReportToPdf(jasperPrint), headers, HttpStatus.OK);
	}

	private Path getUploadPath(String fileFormat, JasperPrint jasperPrint, String fileName)
			throws IOException, JRException {
		String uploadDir = StringUtils.cleanPath("./generated-reports");
		Path uploadPath = Paths.get(uploadDir);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		// generate the report and save it in the just created folder
		if (fileFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, uploadPath + fileName);
		}

		return uploadPath;
	}

	private String getPdfFileLink(String uploadPath) {
		return uploadPath + "/" + "sales.pdf";
	}

	@Override
	public String generateReport(LocalDate localDate, String fileFormat) throws JRException, IOException {
		List<Sale> sales = saleDao.findBySaleDate(localDate);
		// load the file and compile it
		String resourceLocation = "classpath:sales.jrxml";
		JasperPrint jasperPrint = getJasperPrint(sales, resourceLocation);
		// create a folder to store the report
		String fileName = "/" + "report4196271231798306222.pdf";
		Path uploadPath = getUploadPath(fileFormat, jasperPrint, fileName);
		// create a private method that returns the link to the specific pdf file

		return getPdfFileLink(uploadPath.toString());
	}

	@Override
	public List<Sale> findAllSale() {
		return saleDao.findAll();
	}

}
