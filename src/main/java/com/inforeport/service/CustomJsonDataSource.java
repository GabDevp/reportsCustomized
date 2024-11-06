package com.inforeport.service;

//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.List;

import com.inforeport.entity.GenerateReport;

import net.sf.jasperreports.engine.*;

class CustomJsonDataSource implements JRDataSource {
    private final List<GenerateReport> data;
    private int index = -1;

    public CustomJsonDataSource(List<GenerateReport> data) {
        this.data = data;
    }

    @Override
    public boolean next() throws JRException {
        index++;
        return index < data.size();
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        GenerateReport reportData = data.get(index);
        String fieldName = field.getName();

        switch (fieldName) {
            case "document":
                return reportData.getDocument();
            case "name":
                return reportData.getName();
            case "mobile":
                return reportData.getMobile();
            case "city":
            	return reportData.getCity();
            case "status":
            	return reportData.getStatus();
            case "email":
            	return reportData.getEmail();
//            case "imageByte":
//                return getImageFromPath(reportData.getImagePath());
            default:
                return null;
        }
    }
    
//    private byte[] getImageFromPath(String imageByte) throws JRException {
//        Path path = Paths.get(imageByte);
//        try {
//			return Files.readAllBytes(path);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//      }
}