/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import CONEXAO.Conexao;
import MODELO.Mfuncionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDANTE
 */
public class Cfuncionario {

    private PreparedStatement ps;
    private ResultSet rs;
    Conexao c = new Conexao();

    public void salvar(Mfuncionario f) {
        String sql = "insert into funcionario(nome,bi,cargo,usuario,senha,estado) values(?,?,?,?,?,?)";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getBi());
            ps.setString(3, f.getCargo());
            ps.setString(4, f.getEstado());
            ps.setString(5, f.getUsuario());
            ps.setString(6, f.getSenha());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "SUCESSO");
            } else {
                JOptionPane.showMessageDialog(null, "ERRO");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public ArrayList<Mfuncionario> pesquisar(String pesquisar) {
        ArrayList<Mfuncionario> dado = new ArrayList<>();
        String sql = "select * from funcionario where nome like '%"+pesquisar+"%'";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mfuncionario f = new Mfuncionario();
                f.setIdfuncionario(rs.getInt("idf"));
                f.setNome(rs.getString("nome"));
                f.setBi(rs.getString("bi"));
                f.setCargo(rs.getString("cargo"));
                f.setSenha(rs.getString("senha"));
                f.setUsuario(rs.getString("usuario"));
                f.setEstado(rs.getString("estado"));
                dado.add(f);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return dado;
    }

    public void apagar(Mfuncionario f) {
        String sql = "delete from funcionario where idf=?";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, f.getIdfuncionario());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "SUCESSO");
            } else {
                JOptionPane.showMessageDialog(null, "ERRO");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void editar(Mfuncionario f){
        String sql="update funcionario set nome=?,bi=?,cargo=?,estado=?,usuario=?,senha=? where idf=?";
        try {
            ps=c.conectar().prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getBi());
            ps.setString(3, f.getCargo());
            ps.setString(4, f.getEstado());
            ps.setString(5, f.getUsuario());
            ps.setString(6, f.getSenha());
            ps.setInt(7, f.getIdfuncionario());
             if (ps.executeUpdate()==1) {
                JOptionPane.showMessageDialog(null, "SUCESSO");
            } else {
                JOptionPane.showMessageDialog(null, "ERRO");
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
