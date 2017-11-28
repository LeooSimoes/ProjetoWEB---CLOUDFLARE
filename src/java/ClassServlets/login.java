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
