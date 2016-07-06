package com.itis.bobrinskaya.util;

import com.itis.bobrinskaya.model.Orders;
import com.itis.bobrinskaya.model.Productinorder;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Ekaterina on 07.05.2016.
 */
public class PDFDocument extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Orders order = (Orders) map.get("modelObject");
        File file = new File("C:\\Work\\Bobrinskaya_11401_Java_2016\\Cooker3\\src\\main\\webapp\\images\\shot.PNG");
        document.add((Element) file);
        document.add(new Phrase("Order : " + order.getId() + "\n\n"));
        document.add(new Phrase("Date: " + order.getDate() + "\n"));
        document.add(new Phrase("Client: " + order.getUser().getLogin() + "\n"));
        document.add(new Phrase("Phone: " + order.getUser().getPhone() + "\n"));
        document.add(new Phrase("Address: " + order.getAddress() + "\n" ));
        document.add(new Phrase("Note: " + order.getNote() + "\n" ));
        PdfPTable table = new PdfPTable(2);
        PdfPCell header1 = new PdfPCell(new Phrase("Name"));
        PdfPCell header3 = new PdfPCell(new Phrase("Price"));
        header1.setHorizontalAlignment(Element.ALIGN_LEFT);
        header3.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(header1);
        table.addCell(header3);

        //Get data from model
        Collection<Productinorder> products = order.getProductinorderList();
        for (Productinorder product : products) {
            table.addCell(product.getProduct().getName());
            table.addCell(String.valueOf(product.getProduct().getPrice()));
        }
        document.add(table);
        document.add(new Phrase("Price: " + order.getPrice()));
        document.addTitle(String.valueOf(order.getId()));



    }
}

