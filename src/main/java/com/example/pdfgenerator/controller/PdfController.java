package com.example.pdfgenerator.controller;

import com.example.pdfgenerator.service.PdfGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PdfController {

    @Autowired
    private PdfGenerationService pdfGenerationService;

    @PostMapping("/generate-pdf")
    public byte[] generatePdf(@RequestBody String xmlData) throws IOException {
        // Load XLS data (example.xls should be in src/main/resources)
        try (InputStream xlsData = getClass().getResourceAsStream("/example.xls")) {
            return pdfGenerationService.generatePdf(xmlData, xlsData).toByteArray();
        }
    }
}
