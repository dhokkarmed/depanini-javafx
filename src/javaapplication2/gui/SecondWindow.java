/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Mohamed
 */
public class SecondWindow extends Application {
     static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) {
     SecondWindow.primaryStage=primaryStage;
         try {
            Parent root = FXMLLoader.load(getClass().getResource("CategorieClient.fxml"));
                    Scene scene = new Scene(root);   
                    primaryStage.setTitle("");
                    primaryStage.setScene(scene);
                    primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
