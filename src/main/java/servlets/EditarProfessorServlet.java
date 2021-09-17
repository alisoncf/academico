package servlets;

import DAO.AreaDAO;
import DAO.ProfessorDAO;
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

import model.Professor;

/**
 *
 * @author cgpre
 */
@WebServlet("/EditarProfessorServlet")
public class EditarProfessorServlet extends HttpServlet {

    private Professor professor;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("id") == null) { //se não foi passado um id válido
            professor.setId(0);                      //não precisa fazer a busca
        } else {

            int id = Integer.parseInt(request.getParameter("id"));

//            BuscarProfessor();
            professor = new ProfessorDAO().getProfessorById(id);
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\n"
                    + "        <script>\n"
                    + "            $(window).on(\"load\", function () {\n"
                    + "                $.get(\"listajax\", function (responseJson) {\n"
                    + "                    var $select = $(\"#area\");\n"
                    + "                    alert($(\"#id_area.value\"));                              "
                    + "                    $select.find(\"option\").remove();\n"
                    + "                    $.each(responseJson, function (index, area) {\n"
                    + "                       if (area.Id === $(\"#id_area\")) {\n"
                    + "                            $(\"<option value=\" + area.Id + \" selected>\").val(area.Id).text(area.nome).appendTo($select);\n"
                    + "                        }else{\n"
                    + "                            $(\"<option value=\" + area.Id + \">\").val(area.Id).text(area.nome).appendTo($select);\n" 
                    +       "                        }"
                    + "                    });\n"
                             
                    + "                });"
                    + "            });"
                    + "        </script>");
            out.println("<title>Alterar Registro</title>");
            out.println("<link href=\"css/estilo.css\"rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Alterar Registro</h1>");
            out.println("<form method=\"post\" action=\"GravarProfessorServlet\">");
            out.println("<label>id: " + professor.getId() + "</label><br>");
            out.println("<div id=\"divLoad\">\n"
                    + "                <label for=\"area\">Informe uma área</label><br>\n"
                    + "                <select id=\"area\" name=\"area\"></select>  \n"
                    + "            </div>");
            out.println("<input  type=\"hidden\" id=\"id\" name=\"id\""
                    + " value=\"" + professor.getId() + "\"" + " size=\"10\" readonly ><br>");
            out.println("<input  type=\"hidden\" id=\"id_area\" name=\"id_area\""
                    + " value=\"" + professor.getArea().getId() + "\"" + " size=\"10\" readonly ><br>");
            out.println("<label for=\"nome\">Nome</label><br>");
            out.println("<input type=\"text\" id=\"nome\" name=\"nome\" "
                    + "value=\"" + professor.getNome() + "\" size=\"60\" ><br>");
            out.println("<label for=\"email\">Email</label><br>");
            out.println("<input type=\"text\" id=\"email\" name=\"email\" "
                    + "value=\"" + professor.getEmail() + "\" size=\"60\" ><br>");
            out.println("<label for=\"cpf\">CPF</label><br>");
            out.println("<input type=\"text\" id=\"cpf\" name=\"cpf\" "
                    + "value=\"" + professor.getCpf() + "\" ><br><br>");
            out.println("<label for=\"telefone\">Telefone</label><br>");
            out.println("<input type=\"text\" id=\"telefone\" name=\"telefone\" "
                    + "value=\"" + professor.getTelefone() + "\" ><br><br>");

            out.println("<input type=\"submit\" value=\"Enviar\" >");
            out.println("<input type=\"submit\" formaction=\"ListarProfessorsServlet\" value=\"Cancelar\">");
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
