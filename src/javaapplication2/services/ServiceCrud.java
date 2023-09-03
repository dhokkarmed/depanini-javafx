package javaapplication2.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication2.entities.Category;
import javaapplication2.entities.Service;
import javaapplication2.utils.MyConnection;

public class ServiceCrud {

public void ajouterService(Service service) {
    String requete = "INSERT INTO `service`(`name`, `category_id`) VALUES (?, ?)";
    try {
        PreparedStatement pst = new MyConnection().getcnx().prepareStatement(requete);
        pst.setString(1, service.getName());
        pst.setInt(2, service.getCategory().getId());
        pst.executeUpdate();
        System.out.println("Votre Service est ajouté");
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
}


    public List<Service> afficherServices() {
        List<Service> serviceList = new ArrayList<>();
        try {
            String requete2 = "SELECT * FROM service";
            Statement st = new MyConnection().getcnx().createStatement();
            ResultSet rs = st.executeQuery(requete2);
            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getInt("id"));
                service.setName(rs.getString("name"));
    
                // You may also need to fetch the associated category from the database
                int categoryId = rs.getInt("category_id");
                Category category = getCategoryById(categoryId);
                service.setCategory(category);

                serviceList.add(service);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return serviceList;
    }

   public void modifierService(int id, String name, Category category) {
    String sql = "UPDATE service SET name=?, category_id=? WHERE id=?";
    try {
        PreparedStatement pst = new MyConnection().getcnx().prepareStatement(sql);
        pst.setString(1, name);
        pst.setInt(2, category.getId());  // Use 2 instead of 5
        pst.setInt(3, id);                // Use 3 instead of 6

        pst.executeUpdate();
        System.out.println("Service modifié");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}

    public void supprimerService(int id) {
        try {
            String sql = "DELETE FROM service WHERE id=?";
            PreparedStatement pst = new MyConnection().getcnx().prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Votre Service est supprimé");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    
   public Service chercherService(String serviceName) {
    Service service = null;
    try {
        String query = "SELECT * FROM service WHERE name=?";
        PreparedStatement pst = new MyConnection().getcnx().prepareStatement(query);
        pst.setString(1, serviceName);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            service = new Service();
            service.setId(rs.getInt("id"));
            service.setName(rs.getString("name"));

            // Fetch the associated category
            int categoryId = rs.getInt("category_id");
            Category category = getCategoryById(categoryId);
            service.setCategory(category);
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return service;
}

    private Category getCategoryById(int categoryId) {
    Category category = null;
    try {
        String query = "SELECT * FROM category WHERE id=?";
        PreparedStatement pst = new MyConnection().getcnx().prepareStatement(query);
        pst.setInt(1, categoryId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return category;
}
}
