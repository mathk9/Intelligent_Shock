/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author mathn
 */

public class UsuarioDAO {
    
    Connection conn;
    
    public ResultSet autenticacaoUsauario(UsuarioDTO objusuariodto) {
        
        conn = new ConexaoDAO().conectaBD();
        try {
            
            String sql = "select * from Usuario where NomeUsuario = ? and Senha = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getSenha_usuario());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERRO");
            alert.setHeaderText("Não foi possível acessar o banco de dados => UsuarioDAO");
            alert.setContentText(erro.getMessage());
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });  
            
            return null;        

        }
        
    }  
}
