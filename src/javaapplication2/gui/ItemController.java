/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javaapplication2.entities.Category;
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
    private Label categoryName;

  

    @FXML
    private ImageView categoryImage;
   

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(category);
    }

    private Category category;
    private MyListener myListener;

    public void setData(Category category, MyListener myListener) {
        this.category = category;
        this.myListener = myListener;
        categoryName.setText(category.getName());
 
         FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream("C:\\Users\\Mohamed\\Documents\\image\\" + category.getImage());
            Image image = new Image(inputstream, 100, 100, false, false);
            categoryImage.setImage(image);
        } catch (FileNotFoundException ex) {
            
        }
     
    }
}