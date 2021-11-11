package fr.clementharis.javaee.colis.web;

import fr.clementharis.javaee.colis.ejb.ColisOperation;
import fr.clementharis.javaee.colis.ejb.ProgressionOperation;
import fr.clementharis.javaee.colis.jpa.Colis;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Afficher un colis
 */
@WebServlet("/AfficherColis")
public class AfficherColisServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	@EJB
	private ColisOperation colisOperation;

	@EJB
	private ProgressionOperation progressionOperation;

    public AfficherColisServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final List<Colis> colis = colisOperation.findAllColis();
		request.setAttribute("colis", colis);
		request.getRequestDispatcher("/AfficherListColis.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
