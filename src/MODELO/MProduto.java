/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDANTE
 */
public class MProduto {

    private String idproduto;
    private String nome;
    private String tipo;
    private String preco;
    private String descricao;
    private String origem;
    private Mfuncionario funcionario;

    public Mfuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Mfuncionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(String idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void mensagem(String sms) {
        JOptionPane.showMessageDialog(null, sms);
    }
}
