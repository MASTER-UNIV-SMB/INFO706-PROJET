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
import java.util.List;

@WebServlet("/index.html")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private ColisOperation co;

    public HomeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Colis> listeColis = co.findAllColis();

        request.setAttribute("listeColis", listeColis);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
