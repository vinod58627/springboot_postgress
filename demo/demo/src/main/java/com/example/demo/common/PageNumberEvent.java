package com.example.demo.common;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class PageNumberEvent extends PdfPageEventHelper {

    private PdfTemplate total;
    private Font font = new Font(Font.FontFamily.HELVETICA, 10);

    @Override
    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(30, 16);
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {

        PdfContentByte cb = writer.getDirectContent();

        String text = "Page " + writer.getPageNumber() + " of ";

        float x = (document.left() + document.right()) / 2;
        float y = 20;

        ColumnText.showTextAligned(
                cb,
                Element.ALIGN_CENTER,
                new Phrase(text, font),
                x,
                y,
                0
        );

        cb.addTemplate(total, x + 25, y);
    }

    @Override
    public void onCloseDocument(PdfWriter writer, Document document) {

        ColumnText.showTextAligned(
                total,
                Element.ALIGN_LEFT,
                new Phrase(String.valueOf(writer.getPageNumber() - 1), font),
                0,
                0,
                0
        );
    }
}