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

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Consultas c = new Consultas();
        req.setCharacterEncoding("UTF-8");
        try {
            if (c.inserir(req.getParameter("email"), req.getParameter("senha"), req.getParameter("rua"), req.getParameter("cep"), req.getParameter("bairro"), req.getParameter("cidade"), req.getParameter("uf"))) {
                res.sendRedirect("./index.jsp");
            } else {
                res.sendRedirect("./cadastrado.html");
            }
        } catch (SQLException ex) {
            Logger.getLogger(inscrever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
