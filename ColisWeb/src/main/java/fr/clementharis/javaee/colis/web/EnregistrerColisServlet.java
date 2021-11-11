package fr.clementharis.javaee.colis.web;

import fr.clementharis.javaee.colis.ejb.ColisOperation;
import fr.clementharis.javaee.colis.jpa.Colis;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Enregistrer un colis
 */
@WebServlet("/EnregistrerColisServlet")
public class EnregistrerColisServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private ColisOperation co;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrerColisServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Float poids = Float.parseFloat(request.getParameter("poids"));
        Float prix = Float.parseFloat(request.getParameter("prix"));
        String origine = request.getParameter("origine");
        String destination = request.getParameter("destination");

        Colis colis = co.createColis(origine, destination, poids, prix);

        request.setAttribute("colis", colis);
        request.getRequestDispatcher("/AfficherColis.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
