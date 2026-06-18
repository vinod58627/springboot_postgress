package com.example.demo.serviceImpls;

import com.example.demo.common.PageNumberEvent;
import com.example.demo.dto.PageAllResponseDto;
import com.example.demo.repositories.PageRepo;
import com.example.demo.services.PdfGenerationService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itextpdf.text.PageSize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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
            Document doc = new Document(PageSize.A4);
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

    @Override
    public byte[] pdfWithHtml() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("en-IN"));
//        String html = """
//                <html>
//                <style>
//                table, th, td {
//                  border: 1px solid black;
//                  border-collapse: collapse;
//                }
//                </style>
//                <body>
//                    <h1 style='color:blue'>Employee Report</h1>
//                    <p>Vinod Kumar</p>
//                    <table style="width:100%">
//                        <tr>
//                            <th>SlNo</th>
//                            <th>Name</th>
//                            <th>Email</th>
//                            <th>Salary</th>
//                            <th>Branch</th>
//                       </tr>
//                        <tr>
//                            <td>1</td>
//                            <td>Vinod</td>
//                            <td>vinod2gmail.com</td>
//                            <td style="text-align:right">200000</td>
//                            <td>Kurnool</td>
//                        </tr>
//                    </table>
//                </body>
//                </html>
//                """;
        try {
            Document doc = new Document(PageSize.A3);
            PdfWriter writer = PdfWriter.getInstance(doc, out);
            writer.setPageEvent(new PageNumberEvent());
            doc.open();
            BaseColor color = new BaseColor(225, 32, 214);
            Font titleFont = new Font(
                    Font.FontFamily.HELVETICA,
                    16,
                    Font.BOLD + Font.UNDERLINE,
                    color
            );
            Paragraph title = new Paragraph("Pdf Generation with Html Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setPaddingTop(0);
            title.setSpacingAfter(10f);
            doc.add(title);
            List<PageAllResponseDto> users = pageRepo.getAll();

            Long totalSalary = pageRepo.getAll()
                    .stream()
                    .map(PageAllResponseDto::getSalary)
                    .reduce(0L, (a, b) -> a + b);
            System.out.println(totalSalary);
            StringBuilder rows = new StringBuilder();

            int sNo = 1;

            for (PageAllResponseDto user : users) {

                rows.append("""
                        <tr>
                            <td>%d</td>
                            <td>%s</td>
                            <td>%s</td>
                            <td style="text-align:right">%s</td>
                            <td>%s</td>
                        </tr>
                        """.formatted(
                        sNo++,
                        user.getName(),
                        user.getEmail(),
                        formatter.format(user.getSalary()),
                        user.getBranch()
                ));
            }
            String reportTitle = "Employee Salary Report";

            String html = """
                    <html>
                    <style>
                    table {
                        width: 100%%;
                    }
                    table, th, td {
                        border: 0.5px solid #dddddd;
                        border-collapse: collapse;
                    }
                    th {
                        background-color: #17a185;
                        text-align:center;
                    }
                    .note > th{
                        background-color: #1abd9c;
                    }
                    caption{
                        color: #17a185;
                    }
                    th, td {
                        padding: 5px;
                    }
                    </style>
                    <body>
                    <h4 style="color:red"> %s</h4>
                    <table>
                    <caption>Caption</caption>
                    <thead style="color: white">
                    <tr>
                        <th colspan="5" style="text-align: center">Party Wise Deductions</th>
                    </tr>
                        <tr class="note">
                            <th>SlNo</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Salary</th>
                            <th>Branch</th>
                        </tr>
                        </thead>
                        <tbody>
                        %s
                        </tbody>
                         <tfoot>
                         <tr>
                          <td colspan="5" style="text-align:right; background-color: #fff2f2">%s</td>
                         </tr>
                         </tfoot>
                    </table>
                    </body>
                    </html>
                    """.formatted(reportTitle, rows.toString(), formatter.format(totalSalary));
            XMLWorkerHelper.getInstance().parseXHtml(
                    writer,
                    doc,
                    new StringReader(html)
            );

            doc.add(new Paragraph("Vinod Kumar"));

//            PdfPTable table = new PdfPTable(5);
//
//            for (int i = 1; i <= 1000; i++) {
//                table.addCell(String.valueOf(i));
//                table.addCell("Vinod");
//                table.addCell("vinod@gmail.com");
//                table.addCell("200000");
//                table.addCell("Kurnool");
//            }
//
//            doc.add(table);//Just Test It will divide page wise or not
            doc.close();
            return out.toByteArray();
        } catch (DocumentException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
