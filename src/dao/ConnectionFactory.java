/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gabriel Silva
 */
public class ConnectionFactory {
    Connection conn;
    
    public Connection getConexao(){
        try{
            // TENTA ESTABELECER A CONEXÃO COM O BANCO DE DADOS MYSQL PASSANDO OS PARÂMETROS (ENDEREÇO, NOME DA TABELA, USUÁRIO E SENHA)
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"mercado","root","");
            if(conn!=null){
                // SE A TENTATIVA OBTEVE SUCESSO, IMPRIME A MENSAGEM DE SUCESSO NO CONSOLE
                System.out.println("Conectado com Sucesso!");
            }
        }
        catch(SQLException e){
            // SE A TENTATIVA DE CONEXÃO FRACASSOU, TRATA O ERRO E O EXIBE
            throw new RuntimeException("Error"+e);
        }
        // RETORNA A CONEXÃO COM O BANCO DE DADOS
        return conn;
    }
}
