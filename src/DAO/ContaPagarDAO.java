/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import factory.ConnectionFactory;
import model.ContaPagar;
import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author ls
 */
public class ContaPagarDAO {
    private Connection connection;
    int id;
    String identificacao_da_conta;
    float valor;
    String tipo_de_conta;
    String fornecedor_ou_beneficiario;
    String recorrencia;
    String data_pagamento;
    
    //Construtor da classe. O construtor é executado automaticamente
    //sempre que um novo objeto é criado. 
    // ContaPagarDAO pagarDAO = new ContaPagarDAO();
    public ContaPagarDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void inserir(ContaPagar pagar){
        String sql = "INSERT INTO contaPagar(identificacao_da_conta,valor,tipo_de_conta,fornecedor_ou_beneficiario"
                + ",data_pagamento,recorrencia) VALUES(?,?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,pagar.getIdentificacao_da_conta());
            stmt.setFloat(2,pagar.getValor());
            stmt.setString(3,pagar.getTipo_de_conta());
            stmt.setString(4,pagar.getFornecedor_ou_beneficiario());
            stmt.setString(5,pagar.getData_pagamento());
            stmt.setString(6,pagar.getRecorrencia());
            
            stmt.execute();
            stmt.close();
        }
        catch(SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
}
