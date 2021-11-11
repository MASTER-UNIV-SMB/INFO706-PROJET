package fr.clementharis.javaee.colis.web;

import fr.clementharis.javaee.colis.ejb.ColisOperation;
import fr.clementharis.javaee.colis.ejb.ProgressionOperation;
import fr.clementharis.javaee.colis.jpa.Colis;
import fr.clementharis.javaee.colis.jpa.Progression;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Suivre la progression d'un colis
 */
@WebServlet("/SuivreProgressionColisServlet")
public class SuivreProgressionColisServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    private ProgressionOperation progressionOperation;

    @EJB
    private ColisOperation colisOperation;

    public SuivreProgressionColisServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long colisId = Long.parseLong(request.getParameter("id"));

        Colis colis = colisOperation.findColisById(colisId);

        if (colis != null) {
            final List<Progression> progressions = progressionOperation.findColisProgressions(colis);
            request.setAttribute("progressions", progressions);
            request.setAttribute("colis", colis);
            request.getRequestDispatcher("/SuivreProgressionsColis.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/index.html").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
