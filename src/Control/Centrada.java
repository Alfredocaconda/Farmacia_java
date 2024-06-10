/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import CONEXAO.Conexao;
import MODELO.MProduto;
import MODELO.Mentrada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ESTUDANTE
 */
public class Centrada {

    private PreparedStatement ps;
    private ResultSet rs;
    Conexao c = new Conexao();

    public void salvar() {
        
    }

    public ArrayList<Mentrada> consultar() {
        ArrayList<Mentrada> dados = new ArrayList<>();
        String sql = "select p.nome, p.tipo, e.ide,e.qtd, e.datav, e.data "
                + "from produto as p join  entradad as e on e.idpo=p.idp order by e.ide desc";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                Mentrada e= new Mentrada();
                MProduto p= new MProduto();
                
            }
        } catch (Exception e) {
        }
        return dados;
    }
}
