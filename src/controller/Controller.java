/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.sql.SQLException;
import java.util.List;
import model.Nastavnik;
import model.Zvanje;

/**
 *
 * @author necam
 */
public class Controller {
    private static Controller instance;
    private DBBroker dbb;
    
    private static Nastavnik odabraniNastavnik = null;

    public static Controller getInstance() {
        if(instance == null) { 
            instance = new Controller();
        }
        return instance;
    }
    
    private Controller() {
        dbb = new DBBroker();
    }

    public List<Zvanje> vratiZvanja() {
        return dbb.vratiZvanja();
    }

    public boolean unesiNastavnika(String ime, String prezime, Zvanje zvanje) throws SQLException {
        return dbb.unesiNastavnika(ime, prezime, zvanje);
    }

    public List<Nastavnik> vratiNastavnike() {
        return dbb.vratiNastavnike();
    }

    public static Nastavnik getOdabraniNastavnik() {
        return odabraniNastavnik;
    }

    public static void setOdabraniNastavnik(Nastavnik odabraniNastavnik) {
        Controller.odabraniNastavnik = odabraniNastavnik;
    }

    public boolean obrisiNastavnika(int id) throws SQLException {
        return dbb.obrisiNastavnika(id);
    }

    public boolean azurirajNastavnika(int id, String ime, String prezime, Zvanje zvanje) throws SQLException {
        return dbb.azurirajNastavnika(id, ime, prezime, zvanje);
    }

    
    
    
    
}
