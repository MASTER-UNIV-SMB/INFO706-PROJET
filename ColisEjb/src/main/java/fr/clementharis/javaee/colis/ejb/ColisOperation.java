package fr.clementharis.javaee.colis.ejb;

import fr.clementharis.javaee.colis.jpa.Colis;

import java.util.List;

public interface ColisOperation {
    List<Colis> findAllColis();
    Colis findColisById(long id);
    Colis createColis(String origine, String destination, float poids, float prix);
}
