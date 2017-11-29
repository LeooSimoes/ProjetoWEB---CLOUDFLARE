/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassServlets;

import banco.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leona
 */
@WebServlet(name = "buscaLogin", urlPatterns = {"/buscaLogin"})
public class buscaLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Consultas c = new Consultas();

        try {
            res.getWriter().write("" + c.userIgual(req.getParameter("email")));
            req.getRequestDispatcher("./index.jsp").forward(req, res);
        } catch (SQLException ex) {
            Logger.getLogger(buscaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
