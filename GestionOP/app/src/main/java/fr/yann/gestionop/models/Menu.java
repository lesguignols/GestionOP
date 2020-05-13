package fr.yann.gestionop.models;

public class Menu {

    private int id_menu;
    private String description;
    private Double price;
    private boolean can;
    private boolean adherent;

    public Menu(int id_menu, String description, Double price, boolean can, boolean adherent) {
        this.id_menu = id_menu;
        this.description = description;
        this.price = price;
        this.can = can;
        this.adherent = adherent;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isCan() {
        return can;
    }

    public void setCan(boolean can) {
        this.can = can;
    }

    public boolean isAdherent() {
        return adherent;
    }

    public void setAdherent(boolean adherent) {
        this.adherent = adherent;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id_menu=" + id_menu +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", can =" + can +
                ", adherent=" + adherent +
                '}';
    }
}
