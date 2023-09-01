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
import javaapplication2.entities.Categorie;
import javaapplication2.entities.Service;
import javaapplication2.utils.MyConnection;

public class ServiceCrud {

    public void ajouterService(Service service) {
        String requete = "INSERT INTO `service`(`name`, `prix`, `promoStartDate`, `promoEndDate`, `categorie_id`) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = new MyConnection().getcnx().prepareStatement(requete);
            pst.setString(1, service.getName());
            pst.setDouble(2, service.getPrix());
            pst.setDate(3, new java.sql.Date(service.getPromoStartDate().getTime()));
            pst.setDate(4, new java.sql.Date(service.getPromoEndDate().getTime()));
            pst.setInt(5, service.getCategorie().getId());
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
                service.setPrix(rs.getDouble("prix"));
                service.setPromoStartDate(rs.getDate("promoStartDate"));
                service.setPromoEndDate(rs.getDate("promoEndDate"));
                
                // You may also need to fetch the associated category from the database
                int categoryId = rs.getInt("categorie_id");
                Categorie categorie = getCategoryById(categoryId);
                service.setCategorie(categorie);

                serviceList.add(service);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return serviceList;
    }

    public void modifierService(int id, String name, double prix, Date promoStartDate, Date promoEndDate, Categorie categorie) {
        String sql = "UPDATE service SET name=?, prix=?, promoStartDate=?, promoEndDate=?, categorie_id=? WHERE id=?";
        try {
            PreparedStatement pst = new MyConnection().getcnx().prepareStatement(sql);
            pst.setString(1, name);
            pst.setDouble(2, prix);
            pst.setDate(3, new java.sql.Date(promoStartDate.getTime()));
            pst.setDate(4, new java.sql.Date(promoEndDate.getTime()));
            pst.setInt(5, categorie.getId());
            pst.setInt(6, id);

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

    // You can implement additional methods as needed, such as searching for services, etc.
    
    // Helper method to fetch a category by its ID
    private Categorie getCategoryById(int categoryId) {
        // Implement the logic to fetch a category from the database by its ID
        // and return it as a Categorie object.
        // You can use a similar approach as in the CategorieCrud class.
        return null; // Replace with actual logic
    }
}
