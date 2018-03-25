
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

    double taxa, tempo, capital;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {
            taxa = (Double.parseDouble(request.getParameter("taxa"))) / 100;
        } catch (NumberFormatException | ArithmeticException e) {
            taxa = 0.01;
        }
        try {
            tempo = Double.parseDouble(request.getParameter("tempo"));
        } catch (NumberFormatException | ArithmeticException f) {
            tempo = 12;
        }
        try {
            capital = Double.parseDouble(request.getParameter("capital"));
        } catch (NumberFormatException | ArithmeticException e) {
            capital = 5000;
        }
        double montante = capital * pow((1 + taxa), tempo);

        response.setContentType("text/html;charset=UTF-8");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Calculo de Juros compostos</title>");
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
                + String.format("%.2f", capital) + " a uma taxa de juros compostos de "
                + String.format("%.2f", taxa * 100) + "% ao mês, você terá R$"
                + String.format("%.2f", montante) + " ao final de "
                + tempo + " meses</p>");

        if ((montante - capital) / tempo > 200) {

            out.println("<p style= 'color:green'> Bom negócio");
        } else {

            out.println("<p style= 'color:red'> Mal negócio");
        }

        out.println("</body>");
        out.println("</html>");
    }

}
