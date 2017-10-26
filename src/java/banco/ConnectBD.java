package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectBD{
    
    public Connection conn;
    
    public ConnectBD() {
        conn            = null;
        String url      = "jdbc:postgresql://localhost/"; // localizacao do servidor
        String dbName   = "cloudflare";                    // nome do banco de dados
        String driver   = "org.postgresql.Driver";   // nome do driver de conexao
        String userName = "postgres";                    // nome do usuario do banco
        String password = "root";                    // respectiva senha
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url + dbName, userName, password);
        }
        catch (Exception e) {
            System.out.println("Erro no Banco de Dados!\nContate seu Administrador do Sistema!");
            e.printStackTrace();
        }
    }
    
    public Connection getConnection(){
      return conn;
    }
    
    //Fecha a conecção com bco de dados
    public void closeConnection() {
        try                { 
        conn.close(); 
        }
        catch(Exception e) { 
        e.printStackTrace(); 
        }
    } 
    
}
