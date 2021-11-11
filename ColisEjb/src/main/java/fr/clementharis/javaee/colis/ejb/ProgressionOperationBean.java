package fr.clementharis.javaee.colis.ejb;

import fr.clementharis.javaee.colis.jpa.Colis;
import fr.clementharis.javaee.colis.jpa.Etat;
import fr.clementharis.javaee.colis.jpa.Progression;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote
public class ProgressionOperationBean implements ProgressionOperation {

	@PersistenceContext
	private EntityManager em;

	public ProgressionOperationBean() {

	}

	@Override
	public List<Progression> findColisProgressions(final Colis colis) {
		Query query = em.createNamedQuery("findColisProgressions");
		query.setParameter("id", colis.getId());
		return query.getResultList();
	}

	@Override
	public Progression addColisProgression(final Colis colis, final String emplacement, final Etat etat, final float latitude, final float longitude) {
		final Progression progression = new Progression(colis, latitude, longitude, emplacement, etat);
		em.persist(progression);
		return progression;
	}
}
