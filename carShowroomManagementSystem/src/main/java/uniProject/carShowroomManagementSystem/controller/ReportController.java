package uniProject.carShowroomManagementSystem.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import uniProject.carShowroomManagementSystem.business.report.ReportService;

@RestController
@RequestMapping("api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/")
    public String showSales(Model model){
        model.addAttribute("products",reportService.findAllSale());
        return "products";
    }
    
    @PostMapping("/report")
    public String generateReport(@RequestParam("date") String date,
                                 @RequestParam("fileFormat") String fileFormat) throws JRException, IOException {
        LocalDate localDate = LocalDate.parse(date);
        String fileLink = reportService.generateReport(localDate, fileFormat);
        return "redirect:/"+fileLink;
    }
    
    @GetMapping("/report")
    public String getReport() throws JRException, IOException{
    	 return reportService.generate2();
    }
}
