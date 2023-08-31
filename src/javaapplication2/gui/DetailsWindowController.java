/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.gui;

import API.api.DirtyWordsApi;
import dto.DirtyWords;
import javaapplication2.dto.DirtyWordsList;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication2.entities.Categorie;
import javaapplication2.services.CategorieCrud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Screen;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class DetailsWindowController implements Initializable { 
        private DirtyWordsApi dirtyWordsApi;

      static String Picture;
    Categorie c = new Categorie();
            CategorieCrud Ccd = new CategorieCrud();
@FXML
 TableView<Categorie> categoriesTables;
    @FXML
    private TableColumn<Categorie, String> nomcol;
   
   ObservableList<Categorie> oblist = FXCollections.observableArrayList();
    @FXML
    private TextField tfID;
    @FXML
    private TextField tfNOM;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private TextField tfIDrech;
      @FXML
    private Button categorieImage;
   

    /**
     * Initializes the controller class.
     */
      @Override
    public void initialize(URL location, ResourceBundle resources) {
        categoriesTables();
        dirtyWordsApi = new DirtyWordsApi();
    }
 
     private void categoriesTables() {

       

        
        // TODO
        List<Categorie> li = Ccd.afficherCategorie();
        li.forEach(e
                -> {
            oblist.add(e);

            
            nomcol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        }
        );
        categoriesTables.setItems(oblist);
    }
     
    
  
    /*private void refreshTable(MouseEvent event){
         List<Categorie> li = Ccd.afficherCategorie();

        li.forEach(e
                -> {
            oblist.add(e);

            idcol.setCellValueFactory(new PropertyValueFactory<>("Id"));
            nomcol.setCellValueFactory(new PropertyValueFactory<>("nom"));
            

            

        }
        );
      
       
       

//
        categoriesTables.setItems(oblist);

        
        
    }*/

    @FXML
    private void AddCategorie(ActionEvent event) {
        
        DirtyWordsList list = dirtyWordsApi.listOfBadWords();
   
         if(tfNOM.getText().isEmpty()){
           
            
           System.out.print(tfNOM.getText());
           
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ATTENTION");
            alert.setContentText("Veuillez remplir tous les champs obligatoires");
            alert.showAndWait();
            return ;
           
       }
        
        else {
             for (DirtyWords dw : list.getListofBadWords()) {
            if ((tfNOM.getText().contains(dw.getWord()))) {
                
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("no bad words allowed");
            alert.showAndWait();
            return;
           
            }
        }
          
            String nom =tfNOM.getText();
            Categorie c = new Categorie(nom, Picture);
           
            Ccd.ajouterCategorie2(c);

            categoriesTables.getItems().add(c);
        } 
        
    }

    @FXML
    private void UpdateCategorie(ActionEvent event) {
         int id = Integer.parseInt(tfID.getText());
        String nom =tfNOM.getText();
        Ccd.ModifierCategorie(id, nom);
        categoriesTables.getItems().clear();
        categoriesTables();
        
        
    }

    @FXML
    private void DeleteCategorie(ActionEvent event) {
//        int id = Integer.parseInt(tfID.getText());
//        String nom = null;
        
        
        Categorie cr = categoriesTables.getSelectionModel().getSelectedItem();
        int id = cr.getId();
        System.out.print(id);
        Ccd.SupprimerCategorie(id);
        categoriesTables.getItems().clear();
        categoriesTables();
    }
    
    
    @FXML
    
    private String uploadImage() throws java.io.IOException{
        
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("open");
        File image = fileChooser.showOpenDialog(SecondWindow.primaryStage);
        if (image != null) {
            int index = (image.toString().lastIndexOf("."));
            if (index > 0) {
                String extension = image.toString().substring(index + 1);
                if (!(extension.equals("png") || !extension.equals("jpg") || !extension.equals("jpeg"))) {
                    System.err.println("wrong format");
                } else {
                    Random random = new Random();
                    int imageName = random.nextInt(30000000);
                    String pathname = "C:\\Users\\Mohamed\\Documents\\image\\" + imageName + String.valueOf(imageName) + "." + extension;
                    File file1 = new File(pathname);
                    DetailsWindowController.Picture = imageName + String.valueOf(imageName) + "." + extension;
                    Files.copy(image.toPath(), file1.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
        return DetailsWindowController.Picture;
        
    }
    
    
//       private void setCellValueFromtTableToTextField(){
//        categoriesTables.setOnMouseClicked(new E {
//          
//                
//            }
//           
//             
//             
//             
//            
//        
//        }

    @FXML
    private void FindCategorie(ActionEvent event) {
       
        Categorie c = null;
        String nom = tfIDrech.getText();
        c=Ccd.chercher_categorie(nom);
        categoriesTables.getItems().clear();
        categoriesTables.getItems().add(c);
        
    }

    
  
  

   
}    
    

