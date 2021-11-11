package fr.clementharis.javaee.colis.jpa;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries ({
    @NamedQuery(name="findColisProgressions", query="SELECT p FROM Progression p WHERE p.colis.id = :id ORDER BY p.id ASC")
})

@Entity
public class Progression implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Colis colis;

    private float latitude;
    private float longitude;

    private String emplacement;

    private Etat etat;

    public Progression() {

    }

    public Progression(Colis colis, float latitude, float longitude, String emplacement, Etat etat) {
        this.colis = colis;
        this.latitude = latitude;
        this.longitude = longitude;
        this.emplacement = emplacement;
        this.etat = etat;
    }

    public long getId() {
        return id;
    }

    public Colis getColis() {
        return colis;
    }

    public void setColis(Colis colis) {
        this.colis = colis;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
