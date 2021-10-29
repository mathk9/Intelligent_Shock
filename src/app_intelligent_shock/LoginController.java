/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_intelligent_shock;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author mathn
 */
public class LoginController implements Initializable {
    
    @FXML
    private Button btnLogar;
    
    @FXML
    private Button btn_Close;
    
    @FXML
    private Button btn_Minimaze;
    
    @FXML
    private TextField txtLogin;
    
    @FXML
    private TextField txtSenha;
    
    /**
     * Initializes the controller class.
     */

    private Stage stage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        System.exit(0);
    }
    
    @FXML
    private void btnMinAction(ActionEvent event) {
        
        btn_Minimaze.setOnAction(e -> {
        ((Stage)((Button)e.getSource()).getScene().getWindow()).setIconified(true);
        });
    }
    
    @FXML
    private void handleBtnLogar(ActionEvent event) throws IOException {
        try {
            
            UsuarioDTO objusuariodto = new UsuarioDTO();
            
            objusuariodto.setNome_usuario(txtLogin.getText());
            objusuariodto.setSenha_usuario(txtSenha.getText());
            
            UsuarioDAO objusuariodao = new UsuarioDAO();
            ResultSet rsusuariodao = objusuariodao.autenticacaoUsauario(objusuariodto);
            
            if (rsusuariodao.next()) {
                Parent root = FXMLLoader.load(getClass().getResource("MeuConsumo.fxml"));        
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.show();
                closeButtonAction();
            } 
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Falha");
                alert.setHeaderText("Não foi possível logar");
                alert.setContentText("Usuário ou Senha inválida");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                    }
                });
            }            
            
        }
        catch(Exception erro) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERRO");
            alert.setHeaderText("Não foi possível acessar o banco de dados => LoginController");
            alert.setContentText(erro.getMessage());
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });  
        }
    }
    
    @FXML
    private void handleBtnCadastrar(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));        
            Scene scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            closeButtonAction();
        }
        catch(LoadException e) {
            e.printStackTrace();
        }
    }
    
    private void closeButtonAction(){
        final Stage stage = (Stage) btnLogar.getScene().getWindow();
        stage.close();
    } 
    
}
