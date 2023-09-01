package javaapplication2.entities;

import java.util.Date;

public class Service {
    private int id;
    private String name;
    private double prix;
    private Date promoStartDate; // The date when the promotion starts
    private Date promoEndDate;   // The date when the promotion ends
    private Categorie categorie;

    public Service() {
    }

    public Service(String name, double prix, Date promoStartDate, Date promoEndDate, Categorie categorie) {
        this.name = name;
        this.prix = prix;
        this.promoStartDate = promoStartDate;
        this.promoEndDate = promoEndDate;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrix() {
        // Check if the current date is within the promotion period
        Date currentDate = new Date();
        if (promoStartDate != null && promoEndDate != null
                && currentDate.after(promoStartDate) && currentDate.before(promoEndDate)) {
            // Apply a 10% discount
            return prix * 0.9;
        } else {
            return prix; // No discount
        }
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getPromoStartDate() {
        return promoStartDate;
    }

    public void setPromoStartDate(Date promoStartDate) {
        this.promoStartDate = promoStartDate;
    }

    public Date getPromoEndDate() {
        return promoEndDate;
    }

    public void setPromoEndDate(Date promoEndDate) {
        this.promoEndDate = promoEndDate;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prix=" + getPrix() + // Use the calculated price here
                ", promoStartDate=" + promoStartDate +
                ", promoEndDate=" + promoEndDate +
                ", categorie=" + categorie +
                '}';
    }
}

