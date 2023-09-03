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
public class Category {

    public Category() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", image=" + image + '}';
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    private int id;
    private String name ;
    private String image;

    public Category(String name, String image) {
       
        this.name = name;
        this.image = image;
    }

 
    
    
}
