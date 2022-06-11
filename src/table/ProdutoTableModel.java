/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Produto;

/**
 *
 * @author Gabriel Silva
 */
public class ProdutoTableModel extends AbstractTableModel{

    // ATRIBUI A CADA COLUNA UM INTEIRO PARA FACILITAR AS OPERAÇÕES
    public static final int col_codigo = 0;
    public static final int col_descricao = 1;
    public static final int col_preco = 2;
    // CRIA UMA COLLECTION ARRAYLIST QUE ARMAZENARÁ ITENS DO TIPO PRODUTO 
    public ArrayList <Produto> lista;
    
    // O CONSTRUTOR DA CLASSE RECEBE COMO PARÂMETRO A LISTA DE PRODUTOS
    public ProdutoTableModel(ArrayList <Produto> l){
        // SETA A LISTA DO OBJETO COMO A LISTA RECEBIDA PELO CONSTRUTOR
        this.lista = new ArrayList <Produto> (l);
    }
    
    // INFORMA QUE O NÚMERO DE LINHAS DA TABELA É IGUAL AO NÚMERO DE ITENS DA LISTA DE PRODUTOS
    @Override
    public int getRowCount() {
        return lista.size();
    }

    // INFORMA QUE O NÚMERO DE COLUNAS DA TABELA É IGUAL A 3 (CÓDIGO, DESCRIÇÃO E PREÇO)
    @Override
    public int getColumnCount() {
        return 3;
    }

    // ATRIBUI O VALOR A CADA CAMPO DA TABELA DE PRODUTOS
    @Override
    public Object getValueAt(int linhas, int colunas) {
        // SELECIONA O PRODUTO CORRESPONDENTE À LINHA RECEBIDA COMO PARÂMETRO PELA FUNÇÃO
        Produto produto = lista.get(linhas);
        // SELECIONA A COLUNA CORRESPONDENTE À COLUNA RECEBIDA COMO PARÂMETRO PELA FUNÇÃO E RETORNA O RESPECTIVO VALOR A ELA ASSOCIADO 
        if (col_codigo == colunas){
            return produto.getCodigo();
        }
        if (col_descricao == colunas){
            return produto.getDescricao();
        }
        if (col_preco == colunas){
            return produto.getPreco();
        }
        return null;
    }
    
    // ATRIBUI O NOME DE CADA COLUNA DA TABELA, RECEBENDO COMO PARÂMETRO O INTEIRO ASSOCIADO À POSIÇÃO DA COLUNA QUE SE DESEJA NOMEAR
    public String getNameColumn(int colunas){
        if (col_codigo == colunas){
            return "Código";
        }
        if (col_descricao == colunas){
            return "Descrição";
        }
        if (col_preco == colunas){
            return "Preço";
        }
        
        return null;
    }
    
}
