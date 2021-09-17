package servlets;

import DAO.AreaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Area;

/**
 *
 * @author cgpre
 */
@WebServlet(urlPatterns = "/EditarAreaServlet")
public class EditarAreaServlet extends HttpServlet {

    private Area area;

  

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        area = new Area();
 
        area.setNome(request.getParameter("nome"));
        if (request.getParameter("id") == null) { //se não foi passado um id válido
            area.setId(0);                      //não precisa fazer a busca
        } else {
            area.setId(Integer.parseInt(request.getParameter("id")));
//            BuscarArea();
            area = new AreaDAO().getAreaById(area.getId());
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alterar Registro</title>");
            out.println("<link href=\"css/estilo.css\"rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Alterar Registro</h1>");
            out.println("<form method=\"post\" action=\"GravarAreaServlet\">");
            out.println("<label>id: " + area.getId() + "</label><br>");
            out.println("<input  type=\"hidden\" id=\"id\" name=\"id\""
                    + " value=\"" + area.getId() + "\"" + " size=\"10\" readonly ><br>");
            out.println("<label for=\"nome\">Nome</label><br>");
            out.println("<input type=\"text\" id=\"nome\" name=\"nome\" "
                    + "value=\"" + area.getNome() + "\" size=\"60\" ><br>");
           
            out.println("<input type=\"submit\" value=\"Enviar\" >");
            out.println("<input type=\"submit\" formaction=\"ListarAreasServlet\" value=\"Cancelar\">");
            out.println("</form>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
