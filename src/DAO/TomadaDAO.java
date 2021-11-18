/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TomadaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author mathn
 */
public class TomadaDAO {

    Connection conn;

    public ResultSet getTomada(TomadaDTO tomadadto) throws ClassNotFoundException {

        conn = new ConexaoDAO().conectaBD();
        try {

            String sql = "SELECT * FROM tomada WHERE NomeTomada = ? AND LocalTomada = ?";

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, tomadadto.getNomeTomada());
            pstm.setString(2, tomadadto.getLocalTomada());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERRO");
            alert.setHeaderText("Não foi possível acessar o banco de dados => TomadaDAO");
            alert.setContentText(erro.getMessage());
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });

            return null;

        }

    }

    public boolean cadastrarTomada(TomadaDTO tomadadto) throws ClassNotFoundException {

        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "INSERT INTO tomada (NomeTomada, LocalTomada) VALUES (?, ?)";

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, tomadadto.getNomeTomada());
            pstm.setString(2, tomadadto.getLocalTomada());

            pstm.execute();
            pstm.close();
            return true;

        } catch (SQLException erro) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERRO");
            alert.setHeaderText("Não foi possível acessar o banco de dados => TomadaDAO");
            alert.setContentText(erro.getMessage());
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
            return false;
        }

    }
    
    public ObservableList<TomadaDTO> refreshTable() throws ClassNotFoundException {
        ObservableList<TomadaDTO>  TomadaList = FXCollections.observableArrayList();
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "SELECT * FROM `tomada`";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                TomadaList.add(new  TomadaDTO(
                    rs.getInt("IdTomada"),
                    rs.getString("NomeTomada"),
                    rs.getString("LocalTomada")));                
            }
            return TomadaList;
            
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERRO");
            alert.setHeaderText("Não foi possível carregar os dados");
            alert.setContentText(ex.getMessage());
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
            System.out.println("Erro => "+ex);

            return TomadaList;
        }

    }

}
