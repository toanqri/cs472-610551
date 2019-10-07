package mum.cs472;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Simple Calculator</title></head><body>");

        Integer add1 = null;
        Integer add2 = null;
        Integer mul1 = null;
        Integer mul2 = null;

        try {
            add1 = Integer.valueOf(request.getParameter("add1"));
            add2 = Integer.valueOf(request.getParameter("add2"));
        } catch (NumberFormatException ex) {
        }

        StringBuilder sb = new StringBuilder();

        if (add1 != null && add2 != null) {
            sb.append(add1 + " + " + add2 + " = " + (add1 + add2));
            sb.append("\n");
        }

        try {
            mul1 = Integer.valueOf(request.getParameter("mul1"));
            mul2 = Integer.valueOf(request.getParameter("mul2"));
        } catch (NumberFormatException ex) {
        }

        if (mul1 != null && mul2 != null) {
            sb.append(mul1 + " * " + mul2 + " = " + (mul1 * mul2));
        }

        System.out.println(sb.toString());
        if (sb.toString().isEmpty()) {
            out.print("No input!");
        } else {
            out.print(sb.toString());
        }

        out.print("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
