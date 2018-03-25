
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.pow;
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
        
        double taxa = (Double.parseDouble(request.getParameter("taxa"))) / 100;
        double tempo = Double.parseDouble(request.getParameter("tempo"));
        double capital = Double.parseDouble(request.getParameter("capital"));
        
        double montante = capital * pow((1 + taxa),tempo);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JurosServlet</title>");
            out.println("</head>");
            out.println("<body>");

            /*EXERCICIO C*/
            out.println("<h1> Exercício c)</h1>");

            out.println("<p>Montante final com juros compostos para 12 meses: R$" + String.format("%.2f", montante) + "</p>");
            /*ESPAÇAMENTO*/
            out.println("<br/>");
            out.println("<br/>");
            out.println("<hr>");

            
  
            out.println("<p>Para um investimento inicial de R$"
                    + String.format("%.2f", capital)+" a uma taxa de juros compostos de "
                    + String.format("%.2f", taxa*100) +"% ao mês, você terá R$"
                    + String.format("%.2f", montante) + " ao final de "
                    + tempo + " meses</p>");
                
            if((montante-capital)/tempo >200){
            
            out.println("<p style= 'color:green'> Bom negócio");
            }else{
            
            out.println("<p style= 'color:red'> Mal negócio");
            }
                        
            out.println("</body>");
            out.println("</html>");
        }

    }
}
