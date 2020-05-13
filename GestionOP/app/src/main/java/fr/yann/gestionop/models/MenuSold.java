package fr.yann.gestionop.models;

public class MenuSold extends Menu {

    private int id_menu_sold;
    private Drink drink;
    private Adherent person;


    public MenuSold(int id_menu, String description, Double price, boolean can, boolean adherent, int id_menu_sold, Drink drink, Adherent person) {
        super(id_menu, description, price, can, adherent);
        this.id_menu_sold = id_menu_sold;
        this.drink = drink;
        this.person = person;
    }

    public MenuSold(Menu menu, int id_menu_sold, Drink drink, Adherent person){
        super(menu.getId_menu(), menu.getDescription(), menu.getPrice(), menu.isCan(), menu.isAdherent());
        this.id_menu_sold = id_menu_sold;
        this.drink = drink;
        this.person = person;
    }

    public int getId_menu_sold() {
        return id_menu_sold;
    }

    public void setId_menu_sold(int id_menu_sold) {
        this.id_menu_sold = id_menu_sold;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Adherent getPerson() {
        return person;
    }

    public void setPerson(Adherent person) {
        this.person = person;
    }

    @Override
    public String toString() {
        String str = "MenuSold{" +
                "id_menu_sold=" + id_menu_sold +
                "id_menu=" + super.getId_menu() +
                ", description='" + super.getDescription() + '\'' +
                ", price=" + super.getPrice() +
                ", can=" + super.isCan() +
                ", adherent=" + super.isAdherent();
        if (super.isCan()){
            str = str + ", drink=" + drink;
        }
        if (super.isAdherent()) {
            str = str + ", person=" + person;
        }
        return str = str + "}";
    }
}
