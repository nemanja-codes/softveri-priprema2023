/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author necam
 */
public class Nastavnik {
    private int id;
    private String ime;
    private String prezime;
    private Zvanje zvanje;

    public Nastavnik() {
    }

    public Nastavnik(int id, String ime, String prezime, Zvanje zvanje) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.zvanje = zvanje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(Zvanje zvanje) {
        this.zvanje = zvanje;
    }

    @Override
    public String toString() {
        return "Nastavnik{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", zvanje=" + zvanje + '}';
    }
    
    
    
}
