/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import ClassServlets.postagens;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leona
 */
public class Consultas {

    public static int numberArq;
    ConnectBD db = new ConnectBD();
    Connection conn = db.getConnection();
    PreparedStatement pt;

    public boolean userIgual(String user) throws SQLException {

        boolean sucesso = false;

        String sql = "select * from usuarios";
        System.out.println(user);
        try {
            pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                if (rs.getString("usuario").equals(user)) {
                    sucesso = true;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

        conn.close();
        db.closeConnection();
        
        return sucesso;
    }

    public boolean inserir(String user, String pswd, String endereco) throws SQLException {

        ConnectBD db = new ConnectBD();
        Connection conn = db.getConnection();

        boolean sucesso = false;
        System.out.println("dksadaçsl" + endereco);
        if (user.length() > 1 && pswd.length() > 1) {
            if (!userIgual(user)) {
                String sql = "insert into usuarios (usuario, pswd, endereco) values(?, ?, ?)";

                try {
                    pt = conn.prepareStatement(sql);
                    pt.setString(1, user);
                    pt.setString(2, pswd);
                    pt.setString(3, endereco);
                    pt.executeUpdate();
                    sucesso = true;
                    pt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        conn.close();
        db.closeConnection();
        
        return sucesso;
    }

    public boolean inserirPost(int idUser, String titulo, String texto, String file) throws SQLException {

        ConnectBD db = new ConnectBD();
        Connection conn = db.getConnection();
        
        boolean sucesso = false;

        String sql = "insert into post (cliente_id, titulo, texto, file) values(?, ?, ?, ?)";
        
        try {
            pt = conn.prepareStatement(sql);
            pt.setInt(1, idUser);
            pt.setString(2, titulo);
            pt.setString(3, texto);
            pt.setString(4, file);
            pt.executeUpdate();
            sucesso = true;
            pt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

        conn.close();
        db.closeConnection();
        
        return sucesso;
    }

    public boolean logar(String user, String pswd) throws SQLException {
        ConnectBD db = new ConnectBD();
        Connection conn = db.getConnection();

        boolean sucesso = false;

        if (userIgual(user)) {
            String sql = "select * from usuarios where usuario = ? and pswd = ?";

            try {
                pt = conn.prepareStatement(sql);
                pt.setString(1, user);
                pt.setString(2, pswd);
                ResultSet rs = pt.executeQuery();
                if (rs.next()) {
                    sucesso = true;
                }
                pt.close();

            } catch (SQLException ex) {
                Logger.getLogger(Consultas.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

        conn.close();
        db.closeConnection();

        return sucesso;
    }

    public int idUser(String user) throws SQLException {
        ConnectBD db = new ConnectBD();
        Connection conn = db.getConnection();

        int resp = 0;
        if (userIgual(user)) {
            String sql = "select id from usuarios where usuario = ?";

            try {
                pt = conn.prepareStatement(sql);
                pt.setString(1, user);
                ResultSet rs = pt.executeQuery();
                if (rs.next()) {
                    resp = rs.getInt("id");
                }
                pt.close();

            } catch (SQLException ex) {
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        conn.close();
        db.closeConnection();
        return resp;
    }

    public ArrayList<postagens> post(int id) throws SQLException {
        ArrayList<postagens> posts = new ArrayList<postagens>();
        ConnectBD db = new ConnectBD();
        Connection conn = db.getConnection();
        try {
            String sql = "select * from post where cliente_id = ?";

            pt = conn.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet resultSet = pt.executeQuery();
            while (resultSet.next()) {
                postagens p = new postagens();
                p.setId(resultSet.getInt("id"));
                p.setCliente_id(resultSet.getInt("cliente_id"));
                p.setTitulo(resultSet.getString("titulo"));
                p.setTexto(resultSet.getString("texto"));
                p.setFile(resultSet.getString("file"));
                posts.add(p);
            }
            pt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

        conn.close();
        db.closeConnection();
        return posts;

    }

    public ArrayList<postagens> busca(String palavra) throws SQLException {
        ArrayList<postagens> posts = new ArrayList<postagens>();
        ConnectBD db = new ConnectBD();
        Connection conn = db.getConnection();
        
        try {
            String sql = "select * from post where titulo ilike ?";

            pt = conn.prepareStatement(sql);
            pt.setString(1, "%"+palavra+"%");
            ResultSet resultSet = pt.executeQuery();
            while (resultSet.next()) {
                postagens p = new postagens();
                p.setId(resultSet.getInt("id"));
                p.setCliente_id(resultSet.getInt("cliente_id"));
                p.setTitulo(resultSet.getString("titulo"));
                p.setTexto(resultSet.getString("texto"));
                p.setFile(resultSet.getString("file"));
                posts.add(p);
            }
            pt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

        conn.close();
        db.closeConnection();
        return posts;

    }
}
