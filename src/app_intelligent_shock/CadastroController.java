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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author mathn
 */
public class CadastroController implements Initializable {

    @FXML
    private Button btnCadastar;
    
    @FXML
    private Hyperlink btnCancelar;
    
    @FXML
    private Button btn_Close;
    
    @FXML
    private Button btn_Minimaze;
    
    @FXML
    private TextField txtUsuario, txtEmail, txtSenha, txtConfSenha;
    
    private Stage stage;
    
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleBtnCadastrar(ActionEvent event) throws IOException, ClassNotFoundException {
        try {
            
            UsuarioDTO objusuariodto = new UsuarioDTO();
            
            objusuariodto.setNome_usuario(txtUsuario.getText());
            objusuariodto.setSenha_usuario(txtSenha.getText());
            objusuariodto.setEmail(txtEmail.getText());
            
            UsuarioDAO objusuariodao = new UsuarioDAO();
            //if (txtConfSenha.getText() == txtSenha.getText()) {
                if(objusuariodao.cadastrarUsuario(objusuariodto)) {
                    Parent root = FXMLLoader.load(getClass().getResource("MeuConsumo.fxml"));        
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.show();
                    closeButtonAction(); 
                }           
            //}            
        }
        catch(LoadException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Falha");
            alert.setHeaderText("Não foi possível cadastrar");
            alert.setContentText("Erro ao cadastrar " + e);
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }
    }   
    
    @FXML
    private void handleBtnCancelar(ActionEvent event) throws IOException {
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));        
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
        final Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
}
