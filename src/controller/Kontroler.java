/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.Korisnik;
import model.Predmet;
import model.Profesor;

/**
 *
 * @author Omnix
 */
public class Kontroler {
    private List<Korisnik> listaKorisnika = new ArrayList<>();
    private static Kontroler instance;
    private DBBroker dbb;
    
    public static Kontroler getInstance(){
        if(instance == null){
            instance = new Kontroler();
        }
        return instance;
    }

    public Kontroler() {
        dbb = new DBBroker();
        
        Korisnik k1 = new Korisnik("Ognjen", "Pavlovic", "gio@gmail.com", "ognjen");
        Korisnik k2 = new Korisnik("Milana", "Sarac", "milana@gmail.com", "milana");
        Korisnik k3 = new Korisnik("TestIme", "TestPrezime", "", "");
        
        listaKorisnika.add(k1);
        listaKorisnika.add(k2);
        listaKorisnika.add(k3);
    }

    public boolean login(String username, String password) {
        for(Korisnik k : listaKorisnika){
            if(k.getEmail().equals(username) && k.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public String vratiKorisnika(String username, String password) {
        for(Korisnik k : listaKorisnika){
            if(k.getEmail().equals(username) && k.getPassword().equals(password)){
                return k.getIme() + " " + k.getPrezime();
            }
        }
        return "N/A";
    }

    public void kreirajProfesora(String imeProfesora, String prezimeProfesora, String zvanjeProfesora, String emailOsnivaca) {
        dbb.kreirajProfesora(imeProfesora, prezimeProfesora, zvanjeProfesora, emailOsnivaca);
    }

    public List<Profesor> uzmiListuProfesora() {
        return dbb.uzmiListuProfesora();
    }

    public void dodajPredmet(String nazivPredmeta, String kodPredmeta, int espb, Profesor p) {
        dbb.dodajPredmet(nazivPredmeta, kodPredmeta, espb, p);
    }

    public List<Predmet> napuniTabeluPredmeta(Profesor izabraniProfesor) {
        return dbb.napuniTabeluPredmeta(izabraniProfesor);
    }

    public void obrisiPredmet(int id) {
        dbb.obrisiPredmet(id);
    }
    
    
    
    
    
}
