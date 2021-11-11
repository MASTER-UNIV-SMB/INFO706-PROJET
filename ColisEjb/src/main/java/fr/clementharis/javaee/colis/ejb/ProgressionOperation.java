package fr.clementharis.javaee.colis.ejb;

import fr.clementharis.javaee.colis.jpa.Colis;
import fr.clementharis.javaee.colis.jpa.Etat;
import fr.clementharis.javaee.colis.jpa.Progression;

import java.util.List;

public interface ProgressionOperation {
    List<Progression> findColisProgressions(Colis colis);

    Progression addColisProgression(Colis colis, String emplacement, Etat etat, float latitude, float longitude);
}
