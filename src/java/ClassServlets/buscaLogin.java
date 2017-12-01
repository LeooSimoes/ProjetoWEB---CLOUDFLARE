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
import org.json.JSONObject;

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
        
        res.setContentType("aplication/json");
        try {
            JSONObject json = new JSONObject();
            json.put("resultado", c.userIgual(req.getParameter("email")));
            res.getWriter().write(json.toString());
        } catch (SQLException ex) {
            Logger.getLogger(buscaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
