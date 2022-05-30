package uniProject.carShowroomManagementSystem.business.report;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import uniProject.carShowroomManagementSystem.entity.Sale;

public interface ReportService {
	JasperPrint getJasperPrint(List<Sale> sales, String resourceLocation) throws FileNotFoundException, JRException;
	String generateReport(LocalDate localDate, String fileFormat) throws JRException, IOException;
    List<Sale> findAllSale();
    String generate2() throws FileNotFoundException, JRException, IOException;
}
