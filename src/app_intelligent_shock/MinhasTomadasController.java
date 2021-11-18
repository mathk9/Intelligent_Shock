/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_intelligent_shock;

import DAO.ConexaoDAO;
import DAO.TomadaDAO;
import DTO.TomadaDTO;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author mathn
 */
public class MinhasTomadasController implements Initializable {
    
    @FXML
    private Button btn_Close, btn_Minimaze;
    
    /*@FXML
    private Button ;*/
    
    @FXML
    private TableView<TomadaDTO> tomadaTable;
    
    @FXML
    private TableColumn<TomadaDTO, String> Col_Id;
    
    @FXML
    private TableColumn<TomadaDTO, String> Col_NomeTomada;
    
    @FXML
    private TableColumn<TomadaDTO, String> Col_LocalTomada;
    
    @FXML
    private TableColumn<TomadaDTO, String> editCol;
    
    private Stage stage;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDate();
    }    
    
    private void loadDate(){
        
        refresh();
        
        Col_Id.setCellValueFactory(new PropertyValueFactory<>("idTomada"));
        Col_NomeTomada.setCellValueFactory(new PropertyValueFactory<>("nomeTomada"));
        Col_LocalTomada.setCellValueFactory(new PropertyValueFactory<>("localTomada"));
        
        Callback<TableColumn<TomadaDTO, String>, TableCell<TomadaDTO, String>> cellFoctory = (TableColumn<TomadaDTO, String> param) -> {
            // make cell containing buttons
            final TableCell<TomadaDTO, String> cell = new TableCell<TomadaDTO, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        Button deleteIcon = new Button();

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                                + "-fx-background-color: rgba(255,0,0,80);"
                        );
                        deleteIcon.setText("X");
                        deleteIcon.setOnAction((ActionEvent event) -> {
                            
                            try {
                                TomadaDTO tomadadto;
                                tomadadto = tomadaTable.getSelectionModel().getSelectedItem();
                                String query = "DELETE FROM tomada WHERE IdTomada ="+tomadadto.getIdTomada();
                                Connection connection = new ConexaoDAO().conectaBD();
                                PreparedStatement preparedStatement = connection.prepareStatement(query);
                                preparedStatement.execute();
                                refresh();                                
                            
                            } catch (ClassNotFoundException ex) {
                                System.out.println("Erro=>"+ex);
                                
                            } catch (SQLException ex) {
                                System.out.println("Erro=>"+ex);
                            } 

                        });
                        
                        HBox managebtn = new HBox(deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");

                        setGraphic(managebtn);

                        setText(null);
                    }
                }
            };
            return cell;
        };
        editCol.setCellFactory(cellFoctory);
        refresh();
    }
    
    private void refresh(){
        try{
            TomadaDAO tomadadao = new TomadaDAO();
            tomadaTable.setItems(tomadadao.refreshTable());

        }catch(Exception e){
            System.out.println("erro=>"+e);
        }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.exit(0);     
    }
    
    private void closeButtonAction(){
        final Stage stage = (Stage) btn_Close.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void handleBtn_AddTomadaAction(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AddTomada.fxml"));        
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
    
        @FXML
    private void handleBtn_MeuConsumoAction(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MeuConsumo.fxml"));        
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
    
    @FXML
    private void btnMinAction(ActionEvent event) {
        
        btn_Minimaze.setOnAction(e -> {
        ((Stage)((Button)e.getSource()).getScene().getWindow()).setIconified(true);
        });
    }
}
