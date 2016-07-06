package com.itis.bobrinskaya.controller;

import com.itis.bobrinskaya.util.AnotherPdF;
import com.itis.bobrinskaya.model.Orders;
import com.itis.bobrinskaya.service.OrderService;

import com.lowagie.text.Document;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ekaterina on 07.05.2016.
 */
@Controller
public class PdfController {
    @Autowired
    OrderService orderService;
    @Autowired
    AnotherPdF anotherPdF;
    @Autowired
    HttpServletRequest request;
    @RequestMapping(value = "/pdf", method= RequestMethod.POST)
    public String pdf(@RequestParam int orderidid, Model model) throws IOException {
        Orders order = orderService.getOne(orderidid);
        Document document = anotherPdF.apply(order);
       model.addAttribute(document);
        HttpSession session = request.getSession();
        session.setAttribute("ordertopdf", orderidid);

        System.out.println("ExcelPDFController pdf is called");
        return "redirect:/pdf/download";
        // return new ModelAndView("pdfDocument", "modelObject", order);


    }

    @RequestMapping(value = "pdf/download")
    public void download(HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int orderidid = (int) session.getAttribute("ordertopdf");
        String path = "C:\\Work\\Bobrinskaya_11401_Java_2016\\Cooker3\\src\\main\\java\\com\\itis\\bobrinskaya\\util\\";
        String filePathToBeServed = path +  orderidid + ".pdf";//complete file name with path;
        File fileToDownload = new File(filePathToBeServed);
        InputStream inputStream = new FileInputStream(fileToDownload);
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment; filename=" + orderidid + ".pdf");
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
        inputStream.close();
    }

}
