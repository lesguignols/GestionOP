package fr.sphimx.gestionop.models;

import java.lang.reflect.Member;

public class Notice {

    private int id_notice;
    private int mark;
    private Adherent member;
    private String desccription;

    public Notice(int id_notice, int mark, Adherent member, String desccription) {
        this.id_notice = id_notice;
        this.mark = mark;
        this.member = member;
        this.desccription = desccription;
    }

    public int getId_notice() {
        return id_notice;
    }

    public void setId_notice(int id_notice) {
        this.id_notice = id_notice;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Adherent getMember() {
        return member;
    }

    public void setMember(Adherent member) {
        this.member = member;
    }

    public String getDesccription() {
        return desccription;
    }

    public void setDesccription(String desccription) {
        this.desccription = desccription;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id_notice=" + id_notice +
                ", mark=" + mark +
                ", member=" + member +
                ", desccription='" + desccription + '\'' +
                '}';
    }
}
