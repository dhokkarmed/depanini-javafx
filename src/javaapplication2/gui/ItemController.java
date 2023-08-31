/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javaapplication2.entities.Categorie;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javaapplication2.MyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class ItemController {
    @FXML
    private Label categorieName;

  

    @FXML
    private ImageView categorieImage;
   

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(categorie);
    }

    private Categorie categorie;
    private MyListener myListener;

    public void setData(Categorie categorie, MyListener myListener) {
        this.categorie = categorie;
        this.myListener = myListener;
        categorieName.setText(categorie.getNom());
 
         FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream("C:\\Users\\Mohamed\\Documents\\image\\" + categorie.getImage());
            Image image = new Image(inputstream, 100, 100, false, false);
            categorieImage.setImage(image);
        } catch (FileNotFoundException ex) {
            
        }
         System.out.println("zzzz");
    }
}