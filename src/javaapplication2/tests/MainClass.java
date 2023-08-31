/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.tests;

import javaapplication2.entities.Categorie;
import javaapplication2.services.CategorieCrud;
import javaapplication2.utils.MyConnection;

/**
 *
 * @author Mohamed
 */
public class MainClass {
    public static void main(String[] args){
       MyConnection mc = new MyConnection();
       CategorieCrud Ccd = new CategorieCrud();
       Categorie test = new Categorie();
     
     

//       test.setNom("dded");
//              test.setImage("image");
     
       
//       Categorie C1 = new Categorie("zzzzzzmmmmm");
////       Categorie C2 = new Categorie("Plomberie");
//      Ccd.ajouterCategorie2(C1);
       //Ccd.ajouterCategorie2(C2);

       //Ccd.SupprimerCategorie(9);
              //System.out.println(Ccd.afficherCategorie());
      // Ccd.chercher_categorie("22");
       //Ccd.ModifierCategorie(9,"mrama");
    }
}
