package com.example.demo.services;

public interface PdfGenerationService {
    byte[] generatePdf();

    byte[] samplePdf();

    byte[] pdfWithHtml();
}
