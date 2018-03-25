
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.pow;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/juros-compostos.html"})
public class JurosServlet extends HttpServlet {

    private double taxa = 0.001;
    private double montante;
    private double capital = 5000.00;
    private int tempo = 12;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        montante = capital * pow((1 + taxa),tempo);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JurosServlet</title>");
            out.println("</head>");
            out.println("<body>");

            /*EXERCICIO A*/
            out.println("<h1> Exercício a)</h1>");
            out.println("<p>Montante final com juros compostos para 12 meses: R$" + String.format("%.2f", this.montante) + "</p>");
            /*ESPAÇAMENTO*/
            out.println("<br/>");
            out.println("<br/>");
            out.println("<hr>");

            
            /*EXERCICIO B*/
            out.println("<h1> Exercício b)</h1>");
            out.println("<p>Para um investimento inicial de R$"
                    + this.capital+" a uma taxa de juros compostos de "
                    + this.taxa*100 +"% ao mês, você terá R$"
                    + String.format("%.2f", this.montante) + " ao final de "
                    + this.tempo + " meses</p>");
                
                        
                        
            out.println("</body>");
            out.println("</html>");
        }

    }

}
