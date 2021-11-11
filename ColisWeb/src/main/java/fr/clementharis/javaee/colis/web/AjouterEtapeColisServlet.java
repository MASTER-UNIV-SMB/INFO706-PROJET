package fr.clementharis.javaee.colis.web;

import fr.clementharis.javaee.colis.ejb.ColisOperation;
import fr.clementharis.javaee.colis.ejb.ProgressionOperation;
import fr.clementharis.javaee.colis.jpa.Colis;
import fr.clementharis.javaee.colis.jpa.Etat;
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
 * Ajouter une étape à un colis
 */
@WebServlet("/AjouterEtapeColisServlet")
public class AjouterEtapeColisServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private ProgressionOperation po;
    @EJB
    private ColisOperation co;

    public AjouterEtapeColisServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id_colis"));
        final Colis colis = co.findColisById(id);
        float latitude = Float.parseFloat(request.getParameter("latitude"));
        float longitude = Float.parseFloat(request.getParameter("longitude"));
        String emplacement = request.getParameter("emplacement");
        Etat etat = Etat.valueOf(request.getParameter("etat"));

        po.addColisProgression(co.findColisById(id), emplacement, etat, latitude, longitude);

        final List<Progression> progressions = po.findColisProgressions(co.findColisById(id));
        request.setAttribute("progressions", progressions);
        request.setAttribute("colis", colis);
        request.getRequestDispatcher("/SuivreProgressionsColis.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
