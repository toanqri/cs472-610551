package com.example.web;

import com.example.model.BeerExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class BeerSelect extends HttpServlet {
    // version 1
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("Beer Selection Advice<br>");
//        String c = request.getParameter("color");
//        out.println("<br>Got beer color " + c);
//    }

    // version 2
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("color");
        BeerExpert be = new BeerExpert();
        List result = be.getBrands(c);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Beer Selection Advice<br>");

        Iterator it = result.iterator();
        while (it.hasNext()) {
            out.println("<br>try: " + it.next());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
