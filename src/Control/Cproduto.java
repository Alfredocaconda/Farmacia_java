/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import CONEXAO.Conexao;
import MODELO.MProduto;
import MODELO.Mfuncionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDANTE
 */
public class Cproduto {

    Conexao c = new Conexao();
    private PreparedStatement ps;
    private ResultSet rs;

    public void salvar(MProduto p) {
       String sql="insert into produto(nome,tipo,precovenda,descricao,origem,idf) values(?,?,?,?,?,?)";
        try {
            ps=c.conectar().prepareStatement(sql);
            ps.setString(1,p.getNome());
            ps.setString(2,p.getTipo());
            ps.setString(3,p.getPreco());
            ps.setString(4,p.getDescricao());
            ps.setString(5,p.getOrigem());
            ps.setInt(6, p.getFuncionario().getIdfuncionario());
            if (ps.executeUpdate()==1) {
                JOptionPane.showMessageDialog(null, "SUCESSO");
            } else {
                JOptionPane.showMessageDialog(null, "ERRO");
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public ArrayList<MProduto> listar(){
        ArrayList<MProduto> dados= new ArrayList<>();
        String sql= "select p.idp,p.nome,p.precovenda,p.descricao,p.tipo,p.origem,f.nome as nome from produto as p inner join "
                + "funcionario as f on p.idf=f.idf";
        try {
            ps=c.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                MProduto p= new MProduto();
                Mfuncionario f=new Mfuncionario();
               f.setIdfuncionario(rs.getInt("idf"));
               p.setDescricao(rs.getString("descricao"));
               p.setIdproduto(rs.getString("idp"));
               p.setNome(rs.getString("nome"));
               p.setOrigem(rs.getString("origem"));
               p.setPreco(rs.getString("precovenda"));
               p.setTipo(rs.getString("tipo"));
               dados.add(p);
            }
        } catch (Exception e) {
        }
        
        return dados;
    }

}
