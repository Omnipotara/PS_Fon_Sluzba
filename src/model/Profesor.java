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
public class Profesor {
    private int id;
    private String ime;
    private String prezime;
    private String emailUnosa;
    private Zvanje zvanje;

    public Profesor() {
    }

    public Profesor(int id, String ime, String prezime, String emailUnosa, Zvanje zvanje) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.emailUnosa = emailUnosa;
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

    public String getEmailUnosa() {
        return emailUnosa;
    }

    public void setEmailUnosa(String emailUnosa) {
        this.emailUnosa = emailUnosa;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(Zvanje zvanje) {
        this.zvanje = zvanje;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Profesor other = (Profesor) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return Objects.equals(this.emailUnosa, other.emailUnosa);
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    
}
