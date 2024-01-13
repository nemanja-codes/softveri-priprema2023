/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.util.ArrayList;
import java.util.List;
import model.Zvanje;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Nastavnik;

/**
 *
 * @author necam
 */
public class DBBroker {

    public List<Zvanje> vratiZvanja() {
        List<Zvanje> lista = new ArrayList<>();
        String upit = "SELECT * FROM zvanje";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()) {
                int id = rs.getInt("id");
                String naziv = rs.getString("naziv");
                
                Zvanje z = new Zvanje(id, naziv);
                lista.add(z);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean unesiNastavnika(String ime, String prezime, Zvanje zvanje) throws SQLException {
        String upit = "INSERT INTO nastavnik (ime, prezime, zvanje_id) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            
            ps.setString(1, ime);
            ps.setString(2, prezime);
            ps.setInt(3, zvanje.getId());
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            return true;
            
        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Nastavnik> vratiNastavnike() {
        List<Nastavnik> lista = new ArrayList<>();
        String upit = "SELECT * FROM nastavnik n JOIN zvanje z ON n.zvanje_id = z.id ORDER BY z.naziv ASC";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()) {
                int idZvanja = rs.getInt("z.id");
                String nazivZvanja = rs.getString("z.naziv");
                
                Zvanje z = new Zvanje(idZvanja, nazivZvanja);
                
                int id = rs.getInt("n.id");
                String ime = rs.getString("n.ime");
                String prezime = rs.getString("n.prezime");
                
                Nastavnik n = new Nastavnik(id, ime, prezime, z);
                lista.add(n);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean obrisiNastavnika(int id) throws SQLException {
        String upit = "DELETE FROM nastavnik WHERE ID = ?";
        
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            Konekcija.getInstance().getConnection().commit();
            return true;
        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean azurirajNastavnika(int id, String ime, String prezime, Zvanje zvanje) throws SQLException {
        String upit = "UPDATE nastavnik SET ime = ?, prezime = ?, zvanje_id = ? WHERE id = ?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, ime);
            ps.setString(2, prezime);
            ps.setInt(3, zvanje.getId());
            ps.setInt(4, id);
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            return true;
        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return false;
    }
    
}
