package fr.yann.gestionop.models;

import java.util.List;

public class OP {

    private int id_op;
    private String name;
    private String date;
    private String photo;
    private List<Menu> menus;
    private List<MenuSold> menuSolds;
    private Double spent;
    private Double income;
    private List<Notice> notices;
    private String description;
    private Double general_mark;

    public OP(int id_op, String name, String date, String photo, List<Menu> menus, List<MenuSold> menuSolds, Double spent, Double income, List<Notice> notices, String description) {
        this.id_op = id_op;
        this.name = name;
        this.date = date;
        this.photo = photo;
        this.menus = menus;
        this.menuSolds = menuSolds;
        this.spent = spent;
        this.income = income;
        this.notices = notices;
        this.description = description;
        int sum = 0;
        for (Notice n: this.notices){
            sum = sum + n.getMark();
        }
        if(notices.size()!=0){
            this.general_mark = new Double(sum / notices.size());
        } else{
            this.general_mark = 0.0;
        }
    }

    public int getId_op() {
        return id_op;
    }

    public void setId_op(int id_op) {
        this.id_op = id_op;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<MenuSold> getMenuSolds() {
        return menuSolds;
    }

    public void setMenuSolds(List<MenuSold> menuSolds) {
        this.menuSolds = menuSolds;
    }

    public Double getSpent() {
        return spent;
    }

    public void setSpent(Double spent) {
        this.spent = spent;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getGeneral_mark(){
        return general_mark;
    }

    public void addNotice(Notice notice){
        notices.add(notice);
        int sum = 0;
        for (Notice n: notices){
            sum = sum + n.getMark();
        }
        general_mark = new Double(sum / notices.size());
    }

    public List<Notice> getNotices() {
        return notices;
    }

    public void setNotices(List<Notice> notices) {
        this.notices = notices;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "OP{" +
                "id_op=" + id_op +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", photo='" + photo + '\'' +
                ", menus=" + menus +
                ", menuSolds=" + menuSolds +
                ", spent=" + spent +
                ", income=" + income +
                ", general_mark=" + general_mark +
                ", notices=" + notices +
                ", description='" + description + '\'' +
                '}';
    }
}
