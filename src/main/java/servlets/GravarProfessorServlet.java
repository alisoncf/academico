
package servlets;

import DAO.AreaDAO;
import DAO.ProfessorDAO;
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
import model.Professor;

import javax.servlet.http.HttpServlet;
import model.Area;

import model.Professor;



/**
 *
 * @author cgpre
 */
@WebServlet("/GravarProfessorServlet")
public class GravarProfessorServlet extends HttpServlet {

    private Professor professor;
    private ProfessorDAO professorDao;
    private String GravaProfessor() {
        try {
            
            
            professorDao = new ProfessorDAO();
            
            
            
            
            if (professor.getId() != 0) {
                professorDao.Alterar(professor);
                return "Sucesso na operação";
            } else {
                return professorDao.Gravar(professor);
            }

            
        } catch (Exception e) {
            return "erro no context: " + e.getMessage();
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        AreaDAO areadao = new AreaDAO();
        Area area = new Area();
        professor = new Professor();
        professor.setEmail(request.getParameter("email"));
        professor.setCpf(request.getParameter("cpf"));
        professor.setNome(request.getParameter("nome"));
        professor.setTelefone(request.getParameter("telefone"));
        int a = Integer.parseInt( request.getParameter("area"));
        area= areadao.getAreaById(a);
        professor.setArea(area);
        
        if (request.getParameter("id") == null) {
            professor.setId(0);
        } else {
            professor.setId(Integer.parseInt(request.getParameter("id")));
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gravando no Professor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form>");
            out.println("<h2>Gravando novo Professor</h2>");
            out.println("<p>" + GravaProfessor() + "</p>");
            out.println("<input type=\"submit\" formaction=\"ListarProfessoresServlet\" value=\"Lista de professors\">");
            out.println("<input type=\"submit\" formaction=\"index.html\" value=\"Inicio\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        
        }catch (Exception e){
        
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
