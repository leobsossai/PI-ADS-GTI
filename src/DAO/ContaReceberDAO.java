/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import factory.ConnectionFactory;
import model.ContaReceber;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<ContaReceber> getReceber(String recorrencia){
        String sql = "SELECT * FROM contaReceber WHERE recorrencia = ? ORDER BY data_pagamento ASC";
        try {
            PreparedStatement stmt =  this.connection.prepareStatement
        (sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1,recorrencia);
            ResultSet rs = stmt.executeQuery();
            List<ContaReceber> pagamentos = new ArrayList<>();
            while (rs.next()) {
                ContaReceber receber = new ContaReceber();    
                receber.setIdentificacao_da_conta(rs.getString("identificacao_da_conta"));
                receber.setValor(rs.getFloat("valor"));
                receber.setTipo_de_conta(rs.getString("tipo_de_conta"));
                receber.setPagador(rs.getString("pagador"));
                receber.setData_pagamento(rs.getString("data_pagamento"));
                //pagar.setRecorrencia(rs.getString("recorrencia"));
                pagamentos.add(receber);
            }
            return pagamentos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

