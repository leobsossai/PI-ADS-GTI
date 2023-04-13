/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import factory.ConnectionFactory;
import model.ContaReceber;
import java.sql.*;
import java.sql.PreparedStatement;
/**
 *
 * @author ls
 */
public class ContaReceberDAO {
    private Connection connection;
    String identificacao_da_conta;
    float valor;
    String tipo_de_conta;
    String pagador;
    String recorrencia;
    String data_pagamento;
    
    public ContaReceberDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void inserir(ContaReceber receber){
        String sql = "INSERT INTO contaReceber(identificacao_da_conta,valor,tipo_de_conta,pagador"
                + ",data_pagamento,recorrencia) VALUES(?,?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,receber.getIdentificacao_da_conta());
            stmt.setFloat(2,receber.getValor());
            stmt.setString(3,receber.getTipo_de_conta());
            stmt.setString(4,receber.getPagador());
            stmt.setString(5,receber.getData_pagamento());
            stmt.setString(6,receber.getRecorrencia());
            
            stmt.execute();
            stmt.close();
        }
        catch(SQLException u) {
            throw new RuntimeException(u);
        }
    }
}

