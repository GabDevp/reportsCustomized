package com.inforeport.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.inforeport.entity.GenerateReport;
import com.inforeport.service.ReportService;

import net.sf.jasperreports.engine.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping({"/report"})
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	//EXPORT REPORT IN PDF
	@PostMapping("/generate")
	public ResponseEntity<byte[]> exportPdf(@RequestBody List<GenerateReport> generate) throws JRException, IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("Report", "Report.pdf");
        return ResponseEntity.ok().headers(headers).body(service.exportReport(generate));
    }

}
