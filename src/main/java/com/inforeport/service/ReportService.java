package com.inforeport.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.*;

import com.inforeport.entity.GenerateReport;

@Service
public class ReportService {

	public byte[] exportReport(List<GenerateReport> generate) throws JRException, FileNotFoundException {
        return JasperExportManager.exportReportToPdf(getReport(generate));
    }
	
	
    private JasperPrint getReport(List<GenerateReport> generate) throws FileNotFoundException, JRException {
        JRDataSource dataSource = new CustomJsonDataSource(generate);

        JasperPrint report = JasperFillManager.fillReport(
                JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:infopersonalizado.jrxml").getAbsolutePath()), null,
                dataSource
        );
        return report;
    }

}
