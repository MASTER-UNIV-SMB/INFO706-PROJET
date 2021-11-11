package fr.clementharis.javaee.colis.ejb;

import fr.clementharis.javaee.colis.jpa.Colis;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote
public class ColisOperationBean implements ColisOperation {

    @PersistenceContext
    private EntityManager em;

    public ColisOperationBean() {

    }

    @Override
    public List<Colis> findAllColis() {
        final Query query = em.createNamedQuery("findAllColis");
        return query.getResultList();
    }

    @Override
    public Colis findColisById(long id) {
        final Query query = em.createNamedQuery("findColisWithId");
        query.setParameter("id", id);
        if (query.getResultList().size() > 0) {
            return (Colis) query.getResultList().get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public Colis createColis(final String origine, final String destination, final float poids, final float prix) {
        Colis colis = new Colis(poids, prix, origine, destination);
        em.persist(colis);
        return colis;
    }

}
