/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.AreaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.google.gson.Gson;
import model.Area;
 
@WebServlet("/GetAreasAjax")
public class GetAreasAjax extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        AreaDAO dao = new AreaDAO();
 
        try {
 
            List<Area> listArea = dao.ListaAreas("");
            String json = new Gson().toJson(listArea);
 
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
 
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String area = request.getParameter("area");
        String text = "Você selecionou a seguinte área: " + area;
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(text);
    }
}