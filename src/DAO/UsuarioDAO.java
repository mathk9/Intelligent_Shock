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
    
    public ResultSet autenticacaoUsauario(UsuarioDTO objusuariodto) throws ClassNotFoundException{
        
        conn = new ConexaoDAO().conectaBD();
        try {            
            
            String sql = "SELECT * FROM Usuario WHERE NomeUsuario = ? AND Senha = ?";
            
            String senha = HashFunctions.getHashInstance().getHash(objusuariodto.getSenha_usuario().getBytes(), "SHA-256");
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, senha);
            
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
    
    public boolean cadastrarUsuario(UsuarioDTO objusuariodto) throws ClassNotFoundException {
        
         conn = new ConexaoDAO().conectaBD();
         
         try {
            String sql = "INSERT INTO Usuario (NomeUsuario, Email, Senha) VALUES (?, ?, ?)";
            
            String senha = HashFunctions.getHashInstance().getHash(objusuariodto.getSenha_usuario().getBytes(), "SHA-256");
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getEmail());
            pstm.setString(3, senha);

            
            pstm.execute();
            pstm.close();
            return true;
             
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
            return false;            
        }
        
    }
}
