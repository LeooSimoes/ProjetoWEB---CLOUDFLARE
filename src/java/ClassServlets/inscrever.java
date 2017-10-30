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

@WebServlet(urlPatterns = {"/inscrever"})
public class inscrever extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        HttpSession s = req.getSession();
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
            pw.println("                <h2 class=\"crie\" style=\"margin-bottom:20px\">Crie uma conta CloudFlare</h2>");
            pw.println("                <form action=\"./inscrever\" method=\"post\">");
            pw.println("                    <div><input class=\"dadosI\" placeholder=\"Email\" type=\"text\" name=\"email\" value\"\" required=\"required\" aria-invalid=\"true\"></div>");
            pw.println("                    <div><input class=\"dadosI\" placeholder=\"Senha\" type=\"password\" name=\"senha\" value\"\" required=\"required\" aria-invalid=\"true\"></div>");
            pw.println("                    <div><input class=\"dadosI\" placeholder=\"Endereço\" type=\"text\" name=\"endereco\" value\"\"></div>");
            pw.println("                    <div class=\"control\"><div class=\"check\"><input class=\"check\" required=\"required\" aria-invalid=\"true\" type=\"checkbox\"></div>");
            pw.println("                    <span class=\"text\">Aceito os termos e condições da Cloudflare e a política de privacidade.</span></div>");
            pw.println("                    <input class=\"submit\" type=\"submit\" value=\"Criar Conta\">");
            pw.println("                </form>");
            pw.println("            <a class=\"signUp\" href=\"./login\">Logar</a>");
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
            if (c.inserir(req.getParameter("email"), req.getParameter("senha"), req.getParameter("endereco"))) {
                res.sendRedirect("./login");
            } else {
                res.sendRedirect("./cadastrado.html");
            }
        } catch (SQLException ex) {
            Logger.getLogger(inscrever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
