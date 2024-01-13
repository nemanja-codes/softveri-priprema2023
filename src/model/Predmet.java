/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author necam
 */
public class Predmet {
    private int id;
    private String naziv;
    private int esbp;

    public Predmet() {
    }

    public Predmet(int id, String naziv, int esbp) {
        this.id = id;
        this.naziv = naziv;
        this.esbp = esbp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getEsbp() {
        return esbp;
    }

    public void setEsbp(int esbp) {
        this.esbp = esbp;
    }

    @Override
    public String toString() {
        return "Predmet{" + "id=" + id + ", naziv=" + naziv + ", esbp=" + esbp + '}';
    }
    
    
}
