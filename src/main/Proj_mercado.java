/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import view.Produto_view;

/**
 *
 * @author Gabriel Silva
 */
public class Proj_mercado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // INSTANCIA A INTERFACE GRÁFICA E SETA SUA VISIBILIDADE COMO VERDADEIRA, PARA QUE SEJA EXIBIDA
        Produto_view pv = new Produto_view();
        pv.setVisible(true);
    }
    
}
