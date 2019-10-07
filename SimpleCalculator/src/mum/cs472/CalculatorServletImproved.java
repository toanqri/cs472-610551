package mum.cs472;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServletImproved extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html lang='en'><head><meta charset='UTF-8'><title>Simple Calculator</title></head>");
        out.println("<body><form method='post' action='calculatorimproved.do'>");

        String add1Str = request.getParameter("add1");
        String add2Str = request.getParameter("add2");
        String mul1Str = request.getParameter("mul1");
        String mul2Str = request.getParameter("mul2");

        Integer add1 = null;
        Integer add2 = null;
        Integer mul1 = null;
        Integer mul2 = null;

        try {
            add1 = Integer.valueOf(add1Str);
            add2 = Integer.valueOf(add2Str);

            mul1 = Integer.valueOf(mul1Str);
            mul2 = Integer.valueOf(mul2Str);
        } catch (NumberFormatException ex) {
        }

        out.println("<div><input type='text' size='8' name='add1' value='" + add1Str + "'>");
        out.println(" + <input type='text' size='8' name='add2' value='" + add2Str + "'>");
        String add = "";
        if (add1 != null && add2 != null) {
            add = (add1 + add2) + "";
        }
        out.println(" = <input type='text' size='8' value='" + add + "' readonly></div>");

        out.println("<div><input type='text' size='8' name='mul1' value='" + mul1Str + "'>");
        out.println(" * <input type='text' size='8' name='mul2' value='" + mul2Str + "'>");
        String mul = "";
        if (mul1 != null && mul2 != null) {
            mul = (mul1 * mul2) + "";
        }
        out.println(" = <input type='text' size='8' value='" + mul + "' readonly></div>");
        out.println("<input type='submit'></form>");
        out.print("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
