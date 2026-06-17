package com.example.demo.controllers;

import com.example.demo.services.PdfGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pdf")
public class PdfGenerationContoller {

    @Autowired
    private PdfGenerationService pdfGenSer;


    @GetMapping("/basic")
    public ResponseEntity<byte[]> genPdf() {
        byte[] pdfBytes = pdfGenSer.generatePdf();
        HttpHeaders headers = new HttpHeaders();
        headers.add(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=employee-report.pdf"
        );

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

    @GetMapping("/sample")
    public ResponseEntity<byte[]> genPrPdf() {

        HttpHeaders headers = new HttpHeaders();
        byte[] pdfBytes = pdfGenSer.samplePdf();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employee-report.pdf");
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);

    }
    @GetMapping("/pdfWithHtml")
    public ResponseEntity<byte[]> pdfwithHtml() {

        HttpHeaders headers = new HttpHeaders();
        byte[] pdfBytes = pdfGenSer.pdfWithHtml();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employee-report.pdf");
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);

    }


}
