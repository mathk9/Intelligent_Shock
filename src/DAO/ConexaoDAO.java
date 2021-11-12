/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author mathn
 */

public class ConexaoDAO {
    
    public Connection conectaBD() {
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/intelligent_shock?user=root&password=";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException erro) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("ERRO");
            alert.setHeaderText("Não foi possível acessar o banco de dados => ConexaoDAO");
            alert.setContentText(erro.getMessage());
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
            System.out.println(erro);
        }
        return conn;
    }
    
}
