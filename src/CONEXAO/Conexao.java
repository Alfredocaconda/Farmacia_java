/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONEXAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDANTE
 */
public class Conexao {

    private String endereco = "jdbc:mysql://localhost/farmacia";
    private String usuario = "root";
    private String senha = "";
    private Connection c;

    public Connection conectar() {
        try {
            c = DriverManager.getConnection(endereco, usuario, senha);
            // JOptionPane.showConfirmDialog(null,"conectado com sucesso" );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return c;
    }

    public void mensagem(String sms) {
        JOptionPane.showMessageDialog(null, sms);
    }
}
