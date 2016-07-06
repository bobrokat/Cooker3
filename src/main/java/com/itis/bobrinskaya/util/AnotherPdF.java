package com.itis.bobrinskaya.util;

import com.itis.bobrinskaya.model.Orders;
import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.function.Function;

/**
 * Created by Ekaterina on 07.05.2016.
 */

@Component
public class AnotherPdF implements Function<Orders, Document> {
    /**
     * Applies this function to the given argument.
     *
     * @param order the function argument
     * @return the function result
     */
    private Font font;
    @Override
    public Document apply(Orders order) {

        Document document = new Document(PageSize.A4);
        document.addTitle("appointment number " + order.getId());

        try {
            String fontpath = "C:\\Work\\Bobrinskaya_11401_Java_2016\\Cooker3\\src\\main\\webapp\\fonts\\arial.ttf";
           BaseFont helvetica = BaseFont.createFont(fontpath, "cp1251", BaseFont.EMBEDDED);
            font = new Font(helvetica, 10, Font.NORMAL);
            String path = "C:\\Work\\Bobrinskaya_11401_Java_2016\\Cooker3\\src\\main\\java\\com\\itis\\bobrinskaya\\util\\";
            PdfWriter.getInstance(document, new FileOutputStream(  path + order.getId() + ".pdf"));
            document.open();


            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return document;
    }

    private void addTableLine(PdfPTable table, String name, String info) {
        PdfPCell cell;
        cell = new PdfPCell(new Phrase(name, font));
        cell.setColspan(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(info, font));
        cell.setColspan(2);
        table.addCell(cell);
    }

    private static void addEmptyParagraph(Document document) throws DocumentException {
        document.add(new Paragraph("            "));
    }
}
