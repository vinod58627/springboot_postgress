package com.example.demo.serviceImpls;

import com.example.demo.dto.PageAllResponseDto;
import com.example.demo.repositories.PageRepo;
import com.example.demo.services.PdfGenerationService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PdfGenerationImpl implements PdfGenerationService {
    @Autowired
    private PageRepo pageRepo;

    @Override
    public byte[] generatePdf() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            Document document = new Document();

            PdfWriter.getInstance(document, out);

            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);

            Paragraph title = new Paragraph("Employee Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);

            document.add(title);
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Employee Id : EP1001"));
            document.add(new Paragraph("Employee Name : Vinod"));
            document.add(new Paragraph("Department : IT"));

            document.close();
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] samplePdf() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, out);
            doc.open();
//            Font have only 4 parameters 1.font family, 2.font size,3.int style, 4.BaseColor
//            new Font(FontFamily family,
//            float size,
//            int style,
//            BaseColor color)
            BaseColor color = new BaseColor(225, 32, 214);
            Font titleFont = new Font(
                    Font.FontFamily.HELVETICA,
                    20,
                    Font.BOLD + Font.UNDERLINE,
                    color
            );
            Paragraph title = new Paragraph("User Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setPaddingTop(0);
            title.setSpacingAfter(10f);
            doc.add(title);

            doc.add(new Paragraph("Vinod Kumar"));
            doc.add(new Paragraph("\n"));
            PdfPTable tb = new PdfPTable(5);//Here 5 mean 5 columns
            tb.setWidthPercentage(100);

            tb.addCell("SlNo");
            tb.addCell("Name");
            tb.addCell("Email");
            tb.addCell("salary");
            tb.addCell("Branch");
            tb.addCell("1");
            tb.addCell("Vinod");
            tb.addCell("vinod.b@ganil.com");
            tb.addCell(String.valueOf(200000));
            tb.addCell("Kurnool");
            int sNo = 1;
            List<PageAllResponseDto> users = pageRepo.getAll();
            for (PageAllResponseDto user : users) {
                tb.addCell(String.valueOf(++sNo));
                tb.addCell(user.getName());
                tb.addCell(user.getEmail());
                PdfPCell salaryCell = new PdfPCell(new Phrase(String.valueOf(user.getSalary())));
                salaryCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                tb.addCell(salaryCell);
                tb.addCell(user.getBranch());
            }
            doc.add(tb);
            doc.close();
            return out.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
