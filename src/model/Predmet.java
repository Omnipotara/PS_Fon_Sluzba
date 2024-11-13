/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author Omnix
 */
public class Predmet {
    private int id;
    private String naziv;
    private int espb;
    private String kod;
    private Profesor p;

    public Predmet() {
    }

    public Predmet(int id, String naziv, int espb, String kod, Profesor p) {
        this.id = id;
        this.naziv = naziv;
        this.espb = espb;
        this.kod = kod;
        this.p = p;
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

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public Profesor getP() {
        return p;
    }

    public void setP(Profesor p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "Predmet{" + "naziv=" + naziv + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Predmet other = (Predmet) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.naziv, other.naziv);
    }
    
    
}
