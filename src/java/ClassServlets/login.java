package ClassServlets;

import banco.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession s = req.getSession();
        PrintWriter pw = res.getWriter();

        if (s.getAttribute("logado") == null) {
            res.setContentType("text/html;charset=UTF-8");

            pw.println("<!DOCTYPE HTML>");
            pw.println("<html>");
            pw.println("    <head>");
            pw.println("        <title>Cloudflare, a Empresade Desempenho e Segurança Web</title>");
            pw.println("        <meta charset=\"utf-8\" name=\"viewport\" content=\"width=400px\">");
            pw.println("        <link href=\"https://fonts.googleapis.com/css?family=Roboto+Slab:300\" rel=\"stylesheet\">");
            pw.println("        <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300\" rel=\"stylesheet\">");
            pw.println("        <link rel=\"stylesheet\" href=\"./estilo.css\">");
            pw.println("    </head>");
            pw.println("    <body>");
            pw.println("        <div class=\"top\">");
            pw.println("            <a href=\"./index.jsp\"><img class=\"logo-dark\" src=\"./imagens/logo-cloudflare-dark.svg\"></a>");
            pw.println("        </div>");
            pw.println("        <div class=\"tela\">");
            pw.println("            <div class=\"container\">");
            pw.println("                <h2 class=\"crie\">Logue em sua conta CloudFlare</h2>");
            pw.println("                <form action=\"./login\" method=\"post\">");
            pw.println("                    <div><input class=\"dados\" id=\"email\" placeholder=\"Email\" type=\"text\" name=\"email\" value\"\"></div>");
            pw.println("                    <div><input class=\"dados\" id=\"senha\" placeholder=\"Senha\" type=\"password\" name=\"senha\" value\"\"></div>");
            pw.println("                    <input class=\"submit\" id=\"criar\" type=\"submit\" value=\"Logar\">");
            pw.println("                </form>");
            pw.println("            <a class=\"signUp\" href=\"./inscrever\">Cadastrar-se</a>");
            pw.println("            </div>");
            pw.println("        </div>");
            pw.println("        <div class=\"foot\"></div>");
            pw.println("    </body>");
            pw.println("</html>");
        } else {
            res.sendRedirect("./index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Consultas c = new Consultas();
        req.setCharacterEncoding("UTF-8");
        try {
            if (c.logar(req.getParameter("email"), req.getParameter("senha"))) {
                req.getSession().setAttribute("logado", new Boolean(true));
                req.getSession().setAttribute("usuario", req.getParameter("email"));
                res.sendRedirect("./index.jsp");
            } else {
                res.sendRedirect("./incorrect.html");
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
