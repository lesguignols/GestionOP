package fr.sphimx.gestionop.models;

public class Adherent {

    private String card;
    private String name;
    private String firstName;
    private String link_photo;
    private String email;
    private int code;
    private int secret_code;
    private boolean active;
    private boolean member;
    private boolean office_bearer;

    public Adherent(String card, String name, String firstName, String link_photo, String email, int code, int secret_code, boolean active, boolean member, boolean office_bearer) {
        this.card = card;
        this.name = name;
        this.firstName = firstName;
        this.link_photo = link_photo;
        this.email = email;
        this.code = code;
        this.secret_code = secret_code;
        this.active = active;
        this.member = member;
        this.office_bearer = office_bearer;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLink_photo() {
        return link_photo;
    }

    public void setLink_photo(String link_photo) {
        this.link_photo = link_photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getSecret_code() {
        return secret_code;
    }

    public void setSecret_code(int secret_code) {
        this.secret_code = secret_code;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public boolean isOffice_bearer() {
        return office_bearer;
    }

    public void setOffice_bearer(boolean office_bearer) {
        this.office_bearer = office_bearer;
    }

    @Override
    public String toString() {
        return "Adherent{" +
                ", card='" + card + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", link_photo='" + link_photo + '\'' +
                ", email='" + email + '\'' +
                ", code=" + code +
                ", secret_code=" + secret_code +
                ", active=" + active +
                ", member=" + member +
                ", office_bearer=" + office_bearer +
                '}';
    }
}
