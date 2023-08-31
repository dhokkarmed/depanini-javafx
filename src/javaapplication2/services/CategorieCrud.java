 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication2.entities.Categorie;
import javaapplication2.utils.MyConnection;


/**
 *
 * @author Mohamed
 */
public class CategorieCrud {
    
    public void ajouterCategorie2(Categorie C){
     String requete = "INSERT INTO `categorie`(`nom`,`image`) VALUES (?,?)";
        try {
            PreparedStatement pst = new MyConnection().getcnx().prepareStatement(requete);
            pst.setString(1, C.getNom());
            pst.setString(2, C.getImage());
            pst.executeUpdate();
            System.out.println("votre Categorie est ajoutée");
            
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());
        }
    }
    public List<Categorie>afficherCategorie(){
        List<Categorie> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT * FROM categorie";
            Statement st = new MyConnection().getcnx().createStatement();
            ResultSet rs = st.executeQuery(requete2);
            while(rs.next()){
                Categorie c = new Categorie();
                c.setId(rs.getInt("Id"));
                c.setNom(rs.getString("nom"));
                c.setImage(rs.getString("image"));
                myList.add(c);
                
            }
            
              
            
        } catch (SQLException ex) {
           System.err.println(ex.getMessage()) ;
        }
        return myList;
    }
    public void ModifierCategorie(int iden,String nom) {
        String sql = "UPDATE categorie SET nom=? WHERE Id=?";
       try
    {
        PreparedStatement pst = new MyConnection().getcnx().prepareStatement(sql);
        pst.setString(1,nom);
        pst.setInt(2,iden);
        
        pst.executeUpdate();
        System.out.println("Categorie modifiée");
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    public void SupprimerCategorie(int Id){
        try {
            String sql = "DELETE FROM categorie WHERE Id=?";
            PreparedStatement pst = new MyConnection().getcnx().prepareStatement(sql);
            pst.setInt(1,Id);
            pst.executeUpdate();
            System.out.println("votre Categorie est Supprimée");
            
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());
        }
    }
//    public void chercher_categorie(String nomc){
//        String sql ="select * FROM categorie WHERE nom="+nomc;
//        try {
//            PreparedStatement pst = new MyConnection().getcnx().prepareStatement(sql);
//            ResultSet rs = pst.executeQuery(sql);
//            while(rs.next()){
//                System.out.println("id:"+rs.getString(1)+"nom:"+rs.getString(2));
//            }
//            
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CategorieCrud.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
     public Categorie chercher_categorie(String nomc) {
         Categorie c = null;
             
             try {
                 String req = "select * from categorie where nom=?";
                 PreparedStatement st = new MyConnection().getcnx().prepareStatement(req);
                 st.setString(1, nomc);
                 ResultSet rs = st.executeQuery();
                 while (rs.next()) {
                     c = new Categorie(
                   
                        rs.getString(2),
                              rs.getString(3)
                             
                     
                     );}
                 System.out.println("la categorie est"+c.getId()+"%");
             } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
             }
             return c ;
     }
         
      
}




