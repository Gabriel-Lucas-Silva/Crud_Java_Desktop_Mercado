/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gabriel Silva
 */
public class Produto {
    // ATRIBUTOS
    private int codigo;
    private String descricao;
    private double preco;

    
    // CONSTRUTORES
    public Produto() {

    }
    
    public Produto(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }
    

    // SETTERS E GETTERS
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }
    
    
    
}
