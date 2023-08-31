/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.entities;

/**
 *
 * @author Mohamed
 */
public class Categorie {

    public Categorie() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", nom=" + nom + ", image=" + image + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    private int id;
    private String nom ;
    private String image;

    public Categorie(String nom, String image) {
       
        this.nom = nom;
        this.image = image;
    }

 
    
    
}
