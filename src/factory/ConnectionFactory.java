/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;
// faz a importação de classes necessárias para o funcionamento do programa
import java.sql.Connection;
// conexão SQL para JAVA
import java.sql.DriverManager;
// driver de conexão SQL para JAVA
import java.sql.SQLException;
// classe para tratamento de exceções
/**
 *
 * @author ls
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/projeto_integrado", "root", "");
        }
        catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
