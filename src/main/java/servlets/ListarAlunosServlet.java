
package servlets;

import DAO.AlunoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import model.Aluno;
import java.util.List;


public class ListarAlunosServlet extends HttpServlet {
    private Aluno aluno;
    private List<Aluno> listaAlunos = new ArrayList<>(); //lista de alunos
    private String kw;
    
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        kw = request.getParameter("keyword");
        if (kw == null) {
            kw = "";
        }

        try (PrintWriter out = response.getWriter()) {
            AlunoDAO alunodao = new AlunoDAO();
            
            listaAlunos = alunodao.ListaAlunos(kw);
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta>");
            out.println("<link href=\"css/estilo.css\"rel=\"stylesheet\">");
            out.println("</meta>");
            out.println("<title>Lista de Alunos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Alunos</h1>");
            out.println("<form>");
//            out.println(ListarAlunos());
            out.println("Lista de Alunos");
            
            out.println("<table><tr><th>id</th><th>nome</th><th >email</th><th>nascimento</th>"
                    + "<th>alterar</th>"
                    + "<th >excluir</th></tr>");
            for (Iterator<Aluno> iterator = listaAlunos.iterator(); iterator.hasNext();) {
                Aluno next = iterator.next();
                out.println("<tr><td>" + next.getId() + "</td>"
                        + "<td>" + next.getNome() + "</td>"
                        + "<td>" + next.getEmail() + "</td>"
                        + "<td>" + next.getNascimento() + "</td>"
                        + "<td><form><input id=\"id\" name=\"id\" type=\"hidden\" value=" + next.getId() + ">"
                        + "<button type=\"submit\" value=\"alterar\" "
                        + "formaction=\"EditarAlunoServlet\">alterar</button></form></td>"
                        + "<td><form >"
                        + "<input id=\"id\" name=\"id\" "
                        + "type=\"hidden\" "
                        + "value=" + next.getId() + ">"
                        + "<button type=\"submit\" value=\"alterar\" "
                        + "formaction=\"ExcluirAlunoServlet\">excluir</button></form></tr>"
                );
            }
            out.println("</table><br>");
            out.println("<button type=\"button\" onclick=\"history.go(-1)\" value=\"voltar\">voltar</button>");
            out.println("<button type=\"submit\" formaction=\"index.html\" value=\"Inicio\">início</button>");
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
