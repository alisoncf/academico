package servlets;

import DAO.AlunoDAO;
import DAO.AreaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import model.Aluno;

import javax.servlet.http.HttpServlet;

import model.Area;

/**
 *
 * @author cgpre
 */
@WebServlet(urlPatterns = "/GravarAreaServlet")
public class GravarAreaServlet extends HttpServlet {

    private Area area;
    private AreaDAO areaDao;

    private String GravaArea() {
        try {

            areaDao = new AreaDAO();

            if (area.getId() != 0) {
                areaDao.Alterar(area);
            } else {
                areaDao.Gravar(area);
            }

            return "Sucesso na operação";
        } catch (Exception e) {
            return "erro no context: " + e.getMessage();
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        area = new Area();
        request.setCharacterEncoding("UTF-8");
        area.setNome(request.getParameter("nome"));

        if (request.getParameter("id") == null) {
            area.setId(0);
        } else {
            area.setId(Integer.parseInt(request.getParameter("id")));
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gravando Area</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form>");
            out.println("<h2>Gravando nova Area</h2>");
            out.println("<p>" + GravaArea() + "</p>");
            out.println("<input type=\"submit\" formaction=\"ListarAreasServlet\" value=\"Lista de Áreas\">");
            out.println("<input type=\"submit\" formaction=\"index.html\" value=\"Inicio\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
