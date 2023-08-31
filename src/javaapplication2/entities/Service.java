package javaapplication2.entities;

public class Service {
    private int id;
    private String name;
    private double prix;
    private boolean promo;
    private Categorie categorie;

    public Service() {
    }

    public Service(String name, double prix, boolean promo, Categorie categorie) {
        this.name = name;
        this.prix = prix;
        this.promo = promo;
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
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isPromo() {
        return promo;
    }

    public void setPromo(boolean promo) {
        this.promo = promo;
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
                ", prix=" + prix +
                ", promo=" + promo +
                ", categorie=" + categorie +
                '}';
    }
}
