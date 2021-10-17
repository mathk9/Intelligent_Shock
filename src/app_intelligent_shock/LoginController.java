/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_intelligent_shock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
            Parent root = FXMLLoader.load(getClass().getResource("MeuConsumo.fxml"));        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            closeButtonAction();
        }
        catch(LoadException e) {
            e.printStackTrace();
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
