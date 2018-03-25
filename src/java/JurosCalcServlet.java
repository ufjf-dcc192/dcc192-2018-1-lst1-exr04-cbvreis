

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/juros-calc.html"})
public class JurosCalcServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double taxa = (Double.parseDouble( request.getParameter("taxa")))/100;
        double tempo = Double.parseDouble( request.getParameter("tempo"));
        double capital = Double.parseDouble( request.getParameter("capital"));
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JurosServlet</title>");
            out.println("</head>");
            out.println("<body>");

                       
            /*EXERCICIO C e D*/
            out.println("<table>");

            out.println("<tr>");
            out.println("<th> Taxa 0.5</th>");
            out.println("<th> Taxa 1.0</th>");
            out.println("<th> Taxa 1.5 </th>");
            out.println("</tr>");

            for (int i = 1; i <= tempo; i++) {
                out.println("<tr>");
                out.println("<td>" + capital * (1 + i* taxa - 0.005) + "</td>");
                out.println("<td>" + capital * (1 + i *taxa) + "</td>");
                out.println("<td>" + capital * (1 + i *taxa + 0.005) + "</td>");
                out.println("</tr>");

            }

            out.println("</table>");

            
            
            /*EXERCICIO C*/

                        
                        
                        
            out.println("</body>");
            out.println("</html>");
    }

    
}}
