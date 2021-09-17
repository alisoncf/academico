
package servlets;

import DAO.AlunoDAO;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import model.Aluno;

import javax.servlet.http.HttpServlet;

import model.Aluno;



/**
 *
 * @author cgpre
 */
public class GravarAlunoServlet extends HttpServlet {

    private Aluno aluno;
    private AlunoDAO alunoDao;
    private String GravaAluno() {
        try {
            
            
            alunoDao = new AlunoDAO();
            
            
            
            
            if (aluno.getId() != 0) {
                alunoDao.Alterar(aluno);
            } else {
                alunoDao.Gravar(aluno);
            }

            return "Sucesso na operação";
        } catch (Exception e) {
            return "erro no context: " + e.getMessage();
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        aluno = new Aluno();
        aluno.setEmail(request.getParameter("email"));
        aluno.setNascimento(request.getParameter("nascimento"));
        aluno.setNome(request.getParameter("nome"));
        if (request.getParameter("id") == null) {
            aluno.setId(0);
        } else {
            aluno.setId(Integer.parseInt(request.getParameter("id")));
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gravando no Aluno</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form>");
            out.println("<h2>Gravando novo Aluno</h2>");
            out.println("<p>" + GravaAluno() + "</p>");
            out.println("<input type=\"submit\" formaction=\"ListarAlunosServlet\" value=\"Lista de alunos\">");
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
