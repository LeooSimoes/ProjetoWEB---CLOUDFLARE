/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import banco.Consultas;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author leona
 */
@MultipartConfig
@WebServlet(urlPatterns = {"/form"})
public class form extends HttpServlet implements java.io.Serializable {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Consultas c = new Consultas();
        request.setCharacterEncoding("UTF-8");
        Part arquivo = request.getPart("arquivos");

        String nomeAntigo = Paths.get(arquivo.getSubmittedFileName()).getFileName().toString();

        if (!nomeAntigo.equals("")) { //-- Verifica se o foi upado alguma coisa

            String path = "/imagens/post/" + ++(c.numberArq) + nomeAntigo.substring(nomeAntigo.lastIndexOf("."));
            //Adiciona um numero para não houver arquivos com o msm nome e retira a extensão
            InputStream fileContent = arquivo.getInputStream();

            String img = request.getServletContext().getRealPath("");

            File arq = new File(img, path);

            //CRIA O ARQUIVO COLOCANDO EM UM PASTA DENTROO DA PASTA IMAGENS
            try (InputStream input = fileContent) {
                Files.copy(input, arq.toPath());
                int id = Integer.valueOf(request.getParameter("id"));
                String titulo = request.getParameter("titulo");
                String texto = request.getParameter("texto");
                String file = path;
                if (c.inserirPost(id, titulo, texto, file)) {
                    response.sendRedirect("./index.jsp");
                }
            } catch (SQLException ex) {
                Logger.getLogger(form.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            int id = Integer.valueOf(request.getParameter("id"));
            String titulo = request.getParameter("titulo");
            String texto = request.getParameter("texto");
            String file = "";

            try {
                if (c.inserirPost(id, titulo, texto, file)) {
                    response.sendRedirect("./index.jsp");
                }
            } catch (SQLException ex) {
                Logger.getLogger(form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
