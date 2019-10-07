package mum.cs472;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");

        if (quiz.getCurrentQuestion() <= 4) {
            Integer answer = null;
            try {
                answer = Integer.valueOf(request.getParameter("number"));
            } catch (NumberFormatException e) {

            }
            if (answer != null) {
                quiz.checkAnswer(answer);
                if (quiz.getCurrentQuestion() <= 4) {
                    this.doGet(request, response);
                } else {
                    out.println("<head><meta charset='UTF-8'><title>Quiz Servlet Lab</title>");
                    out.println("<link href='quiz.css' type='text/css' rel='stylesheet'></head>");
                    out.println("<body><fieldset><legend>The Number Quiz</legend>");
                    out.println("<p>Your current score is " + quiz.getScore() + ".</p>");
                    out.println("<p>Your have completed the Number Quiz, with a score of " + quiz.getScore() + " out of 5.");
                    out.println("<form method='post'><input type='submit' value='Start Again'></form>");
                    out.println("</fieldset></body></html>");
                }
            }
        } else {
            session.removeAttribute("quiz");
            this.doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        if (quiz == null) {
            quiz = new Quiz();
            session.setAttribute("quiz", quiz);
        }

        PrintWriter out = response.getWriter();
        out.println("<head><meta charset='UTF-8'><title>Quiz Servlet Lab</title>");
        out.println("<link href='quiz.css' type='text/css' rel='stylesheet'></head>");
        out.println("<body><fieldset><legend>The Number Quiz</legend>");
        out.println("<form method='post'>");
        out.println("<p>Your current score is " + quiz.getScore() + ".</p>");
        out.println("<p>Guest the next number in the sequence.</p>");
        out.println("<p>" + quiz.getNumberSequence() + "</p>");
        out.println("<div><label>Your answer: <input type='number' size='8' name='number' required></label></div>");
        out.println("<input type='submit'></form>");
        out.println("</fieldset></body></html>");
    }
}
