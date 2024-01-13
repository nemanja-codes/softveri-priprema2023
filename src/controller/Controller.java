/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.List;
import model.Zvanje;

/**
 *
 * @author necam
 */
public class Controller {
    private static Controller instance;
    private DBBroker dbb;

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

    public boolean unesiNastavnika(String ime, String prezime, Zvanje zvanje) {
        return dbb.unesiNastavnika(ime, prezime, zvanje);
    }
    
    
}
