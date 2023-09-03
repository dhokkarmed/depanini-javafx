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
import javaapplication2.entities.Category;

import javaapplication2.utils.MyConnection;


/**
 *
 * @author Mohamed
 */
public class CategoryCrud {
    
    public void ajouterCategory2(Category C){
     String requete = "INSERT INTO `category`(`name`,`image`) VALUES (?,?)";
        try {
            PreparedStatement pst = new MyConnection().getcnx().prepareStatement(requete);
            pst.setString(1, C.getName());
            pst.setString(2, C.getImage());
            pst.executeUpdate();
            System.out.println("votre Category est ajoutée");
            
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());
        }
    }
    public List<Category>afficherCategory(){
        List<Category> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT * FROM category";
            Statement st = new MyConnection().getcnx().createStatement();
            ResultSet rs = st.executeQuery(requete2);
            while(rs.next()){
                Category c = new Category();
                c.setId(rs.getInt("Id"));
                c.setName(rs.getString("name"));
                c.setImage(rs.getString("image"));
                myList.add(c);
                
            }
            
              
            
        } catch (SQLException ex) {
           System.err.println(ex.getMessage()) ;
        }
        return myList;
    }
    public void ModifierCategory(int iden,String name) {
        String sql = "UPDATE category SET name=? WHERE Id=?";
       try
    {
        PreparedStatement pst = new MyConnection().getcnx().prepareStatement(sql);
        pst.setString(1,name);
        pst.setInt(2,iden);
        
        pst.executeUpdate();
        System.out.println("Category modifiée");
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    public void SupprimerCategory(int Id){
        try {
            String sql = "DELETE FROM category WHERE Id=?";
            PreparedStatement pst = new MyConnection().getcnx().prepareStatement(sql);
            pst.setInt(1,Id);
            pst.executeUpdate();
            System.out.println("votre Category est Supprimée");
            
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());
        }
    }
//    public void chercher_category(String namec){
//        String sql ="select * FROM category WHERE name="+namec;
//        try {
//            PreparedStatement pst = new MyConnection().getcnx().prepareStatement(sql);
//            ResultSet rs = pst.executeQuery(sql);
//            while(rs.next()){
//                System.out.println("id:"+rs.getString(1)+"name:"+rs.getString(2));
//            }
//            
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryCrud.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
     public Category chercher_category(String namec) {
         Category c = null;
             
             try {
                 String req = "select * from category where name=?";
                 PreparedStatement st = new MyConnection().getcnx().prepareStatement(req);
                 st.setString(1, namec);
                 ResultSet rs = st.executeQuery();
                 while (rs.next()) {
                     c = new Category(
                   
                        rs.getString(2),
                              rs.getString(3)
                             
                     
                     );}
                 System.out.println("la category est"+c.getId()+"%");
             } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
             }
             return c ;
     }
         
      public Category getCategoryByName(String name) {
    Category category = null;
    try {
        String query = "SELECT * FROM category WHERE name=?";
        PreparedStatement pst = new MyConnection().getcnx().prepareStatement(query);
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            category = new Category();
            category.setId(rs.getInt("Id"));
            category.setName(rs.getString("name"));
            category.setImage(rs.getString("image"));
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return category;
}
public List<String> getCategoryNames() {
    List<String> categoryNames = new ArrayList<>();
    try {
        String query = "SELECT name FROM category";
        Statement statement = new MyConnection().getcnx().createStatement();
        ResultSet rs = statement.executeQuery(query);
        
        while (rs.next()) {
            categoryNames.add(rs.getString("name"));
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return categoryNames;
}

}




