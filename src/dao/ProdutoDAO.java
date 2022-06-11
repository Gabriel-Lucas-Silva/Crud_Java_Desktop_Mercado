/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author Gabriel Silva
 */
public class ProdutoDAO {
    public Statement st;
    Connection conn;
    public PreparedStatement stmn;
    public ResultSet rs;
    public ArrayList <Produto> lista = new ArrayList();
    
    // O CONSTRUTOR ESTABELECERÁ A CONEXÃO COM O BANCO DE DADOS
    public ProdutoDAO() {
        conn = (Connection) new ConnectionFactory().getConexao();
    }
    
    // FUNÇÃO PARA INSERIR PRODUTOS NO BANCO DE DADOS
    public void inserir(Produto produto){
        // COMANDO SQL PARA INSERÇÃO
        String sql = "INSERT INTO produto "
            + "(descricao_produto,preco_produto)"
        + "VALUES (?,?)";

        // TENTATIVA DE INSERÇÃO
        try{
            stmn = (PreparedStatement) conn.prepareStatement(sql);
            // SETA O PRIMEIRO VALOR DO COMANDO COMO A DESCRIÇÃO, PASSADA NO OBJETO DO TIPO PRODUTO RECEBIDO COMO PARÂMETRO
            stmn.setString(1,produto.getDescricao());
            // SETA O SEGUNDO VALOR DO COMANDO COMO O PREÇO, PASSADA NO OBJETO DO TIPO PRODUTO RECEBIDO COMO PARÂMETRO
            stmn.setDouble(2, produto.getPreco());
            // EXECUTA O COMANDO NO BANCO DE DADOS
            stmn.execute();
            // ENCERRA A INTERAÇÃO COM O BANCO DE DADOS
            stmn.close();
            // IMPRIME A MENSAGEM DE SUCESSO NO CONSOLE
            System.out.println("Cadastrado com Sucesso!");
        }
        catch(SQLException e ){
            // SE A TENTATIVA DE CADASTRO FRACASSOU, O ERRO É TRATADO E A MENSAGEM É EXIBIDA
            throw new RuntimeException("Error 2"+e);
        }
    }
    
    // FUNÇÃO PARA EDITAR UM PRODUTO
    public void alterar(Produto produto){
        String sql = "UPDATE produto SET descricao_produto =?,preco_produto=? WHERE id_produto=?";

        try{
            stmn = (PreparedStatement) conn.prepareStatement(sql);
            stmn.setString(1,produto.getDescricao());
            stmn.setDouble(2, produto.getPreco());
            stmn.setInt(3, produto.getCodigo());
            stmn.execute();
            stmn.close();
            System.out.println("Alterado com Sucesso!");
        }
        catch(SQLException e ){
            throw new RuntimeException("Error 3"+e);
        }
    }
    
    // FUNÇÃO PARA EXLUSÃO DE UM PRODUTO
    public void excluir(int codigo){
        String sql = "DELETE FROM produto WHERE id_produto="+codigo;

        try{
            stmn = (PreparedStatement) conn.prepareStatement(sql);
            stmn.execute();
            stmn.close();
            System.out.println("Excluido com Sucesso!");
        }
        catch(SQLException e ){
            throw new RuntimeException("Error 4"+e);
        }
    }
    
    // FUNÇÃO PARA LISTAR TODOS OS PRODUTOS DO BANCO DE DADOS
    public ArrayList <Produto> listarProdutos(){
        String sql = "SELECT * FROM produto";
        
        try{
            st = (Statement) conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                // ENQUANTO HOUVER UM REGISTRO A SER CONSIDERADO (LINHA DA TABELA DO BANCO DE DADOS), SERÁ CRIADO UM NOVO OBJETO DO TIPO PRODUTO, QUE RECEBERÁ AS RESPECTIVAS INFORMAÇÕES DO REGISTRO DO BANCO DE DADOS
                Produto p = new Produto();
                p.setCodigo(rs.getInt("id_produto"));
                p.setDescricao(rs.getString("descricao_produto"));
                p.setPreco(rs.getDouble("preco_produto"));
                // O NOVO OBJETO É ADICIONADO À LISTA DE PRODUTOS
                lista.add(p);
            }
            System.out.println("Listado com Sucesso!");
        }
        catch(SQLException e ){
            throw new RuntimeException("Error 5"+e);
        }
        
        // RETORNA A LISTA DE PRODUTOS
        return lista;
    }
    
    // FUNÇÃO PARA LISTAR APENAS OS PRODUTOS QUE CONTENHAM NA DESCRIÇÃO O QUE FOI ESPECIFICADO NO CAMPO DE BUSCA
    public ArrayList <Produto> pesquisar(String descricao){
        String sql = "SELECT * FROM produto WHERE descricao_produto LIKE '%"+descricao+"%'";
        // EXCLUI TODOS OS ITENS DA LISTA DE PRODUTOS
        lista.removeAll(lista);
        try{
            st = (Statement) conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                Produto p = new Produto();
                p.setCodigo(rs.getInt("id_produto"));
                p.setDescricao(rs.getString("descricao_produto"));
                p.setPreco(rs.getDouble("preco_produto"));
                lista.add(p);
            }
            System.out.println("Listado com Sucesso!");
        }
        catch(SQLException e ){
            throw new RuntimeException("Error 6"+e);
        }
        
        return lista;
    }
}

