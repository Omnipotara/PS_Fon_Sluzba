/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Predmet;
import model.Profesor;
import model.Zvanje;

/**
 *
 * @author Omnix
 */
public class DBBroker {

    public void kreirajProfesora(String imeProfesora, String prezimeProfesora, String zvanjeProfesora, String emailOsnivaca) {
        try {
            String upit = "INSERT INTO PROFESORI (ime, prezime, emailAutora, zvanje) VALUES (?,?,?, ?)";
            PreparedStatement ps = Konekcija.getInstance().getKonekcija().prepareStatement(upit);
            ps.setString(1, imeProfesora);
            ps.setString(2, prezimeProfesora);
            ps.setString(3, emailOsnivaca);
            ps.setString(4, zvanjeProfesora);
            
            ps.executeUpdate();
            Konekcija.getInstance().getKonekcija().commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Profesor> uzmiListuProfesora() {
        
        List<Profesor> listaProfesora = new ArrayList<>();
        
        try {
            String upit = "SELECT * FROM PROFESORI";
            Statement st = Konekcija.getInstance().getKonekcija().createStatement();
            ResultSet rs = st.executeQuery(upit);
            
            while(rs.next()){
                Profesor p = new Profesor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), Zvanje.valueOf(rs.getString(5)));
                listaProfesora.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProfesora;
    }

    public void dodajPredmet(String nazivPredmeta, String kodPredmeta, int espb, Profesor p) {
        try {
            String upit = "INSERT INTO PREDMETI (naziv, kod, espb, idProfesora) VALUES (?,?,?,?)";
            PreparedStatement ps = Konekcija.getInstance().getKonekcija().prepareStatement(upit);
            ps.setString(1, nazivPredmeta);
            ps.setString(2, kodPredmeta);
            ps.setInt(3, espb);
            ps.setInt(4, p.getId());
            
            ps.executeUpdate();
            Konekcija.getInstance().getKonekcija().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public List<Predmet> napuniTabeluPredmeta(Profesor izabraniProfesor) {
        List<Predmet> listaPredmeta = new ArrayList<>();
        try {
            int idProfesora = izabraniProfesor.getId();
            String upit = "SELECT p.id, p.naziv, p.kod, p.espb FROM PREDMETI P JOIN PROFESORI PR ON P.idProfesora = PR.id WHERE P.idProfesora =?";
            
            PreparedStatement ps = Konekcija.getInstance().getKonekcija().prepareStatement(upit);
            ps.setInt(1, idProfesora);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Predmet p = new Predmet(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getString(3), izabraniProfesor);
                listaPredmeta.add(p);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return listaPredmeta;
    }

    public void obrisiPredmet(int id) {
        try {
            String upit = "DELETE FROM PREDMETI P WHERE P.ID =?";
            PreparedStatement ps = Konekcija.getInstance().getKonekcija().prepareStatement(upit);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            Konekcija.getInstance().getKonekcija().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
