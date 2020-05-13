package fr.yann.gestionop.models;

public class Drink {

    private String barcode;
    private String name;

    public Drink(String barcode, String name) {
        this.barcode = barcode;
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
