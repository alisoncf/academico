
package servlets;

import DAO.AreaDAO;
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
import model.Area;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/ListarAreasServlet", name = "ListarAreasServlet"   )
public class ListarAreasServlet extends HttpServlet {
    private Area area;
    private List<Area> listaAreas = new ArrayList<>(); //lista de areas
    private String kw;
    private String action;
    private String retorno;
    private boolean selecionar;

    
    private String Listar(){
            AreaDAO areadao = new AreaDAO();
            String s;
            listaAreas = areadao.ListaAreas(kw);
            
            
            s = "<!DOCTYPE html>"
            + "<html>"
            + "<head>"
            +"<meta>"
            +"<link href=\"css/estilo.css\"rel=\"stylesheet\">"
            +"</meta>"
            +"<title>Lista de Areas</title>"
            +"</head>"
            +"<body>"
            +"<h1>Lista de Areas</h1>"
            +"<form>"
            +"Lista de Areas"
            +"<table><tr><th>id</th><th>nome</th>"
                    + "<th>alterar</th>"
                    + "<th >excluir</th></tr>";
            for (Iterator<Area> iterator = listaAreas.iterator(); iterator.hasNext();) {
                Area next = iterator.next();
                s+="<tr><td>" + next.getId() + "</td>"
                        + "<td>" + next.getNome() + "</td>"
                        + "<td><form><input id=\"id\" name=\"id\" type=\"hidden\" value=" + next.getId() + ">"
                        + "<button type=\"submit\" value=\"alterar\" "
                        + "formaction=\"EditarAreaServlet\">alterar</button></form></td>"
                        + "<td><form >"
                        + "<input id=\"id\" name=\"id\" "
                        + "type=\"hidden\" "
                        + "value=" + next.getId() + ">"
                        + "<button type=\"submit\" value=\"alterar\" "
                        + "formaction=\"ExcluirAreaServlet\">excluir</button></form></tr>";
                
            }
            s+="</table><br>"
            +"<button type=\"button\" onclick=\"history.go(-1)\" value=\"voltar\">voltar</button>"
            +"<button type=\"submit\" formaction=\"index.html\" value=\"Inicio\">início</button>"
            +"</body>"
            +"</html>";
            
            return s;
    }
    private String Selecionar(){
            AreaDAO areadao = new AreaDAO();
            String s;
            listaAreas = areadao.ListaAreas(kw);
            
            
            s = "<!DOCTYPE html>"
            + "<html>"
            + "<head>"
            +"<meta>"
            +"<link href=\"css/estilo.css\"rel=\"stylesheet\">"
            +"</meta>"
            +"<title>Lista de Areas</title>"
            +"</head>"
            +"<body>"
            +"<h1>Lista de Areas</h1>"
            +"<form>"
            +"Lista de Areas"
            +"<table><tr><th>id</th><th>nome</th>"
                    + "<th>Selecionar</th>"
                    + "</tr>";
            for (Iterator<Area> iterator = listaAreas.iterator(); iterator.hasNext();) {
                Area next = iterator.next();
                s+="<tr><td>" + next.getId() + "</td>"
                        + "<td>" + next.getNome() + "</td>"
                        + "<td>"
                        + "<form>"
                        + "<input id=\"id\" name=\"id\" type=\"hidden\" value=" + next.getId() + ">"
                        + "<button type=\"submit\" value=\"selecionar\" "
                        + "formaction=\"SelecionarAreaServlet\">Selecionar</button>"
                        + "</form>"
                        + "</td>"
                        + "</tr>";
                
            }
            s+="</table><br>"
            +"<button type=\"button\" onclick=\"history.go(-1)\" value=\"voltar\">voltar</button>"
            +"<button type=\"submit\" formaction=\"index.html\" value=\"Inicio\">início</button>"
            +"</body>"
            +"</html>";
            
            return s;
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        kw = request.getParameter("keyword");
        
        if (kw == null) {
            kw = "";
        }
        action = request.getParameter("action");
        
        if ("selecionar".equals(action)){
            retorno = Selecionar();
        }else{
            retorno = Listar();
            
        }
        try (PrintWriter out = response.getWriter()) {
            out.println(retorno);
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
