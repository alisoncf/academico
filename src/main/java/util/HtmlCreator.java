/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import org.w3c.dom.Document;

/**
 *
 * @author Administrador
 */
public class HtmlCreator {

    public HtmlCreator(){}
    public String head;
    public String meta;
    public String body;
    public String titulo;
    public String actionForm;
    public String html;
    public List<String> forms;
    public String getHtml(){
        
            html="";
            html+=("<!DOCTYPE html>");
            html+=("<html>");
            html+=("<head>");
            html+=("<title>Alterar Registro</title>");
            html+=("<link href=\"css/estilo.css\"rel=\"stylesheet\">");
            html+=("</head>");
            html+=("<body>");
            html+=("<h1>" + this.titulo + "</h1>");
            
            html+=("</body>");
            html+=("</html>");
            return this.html;
    }
    
    private void addForm(String id, String nome, String metodo, String action){
        String s="";
//        s = "<form method=\"post\" action=\""+ actionForm+  "\">");
        
    
//        Document d = new HtmlDocument
    }
    private void addControle(String id, String valor){
        String s="";
//        s+=("<form method=\"post\" action=\""+ actionForm+  "\">");
//            s+=("<label>id: " + aluno.getId() + "</label><br>");
//            s+=("<input  type=\"hidden\" id=\"id\" name=\"id\""
//                    + " value=\"" + aluno.getId() + "\"" + " size=\"10\" readonly ><br>");
//            s+=("<label for=\"nome\">Nome</label><br>");
//            s+=("<input type=\"text\" id=\"nome\" name=\"nome\" "
//                    + "value=\"" + aluno.getNome() + "\" size=\"60\" ><br>");
//            s+=("<label for=\"email\">Email</label><br>");
//            s+=("<input type=\"text\" id=\"email\" name=\"email\" "
//                    + "value=\"" + aluno.getEmail() + "\" size=\"60\" ><br>");
//            s+=("<label for=\"nascimento\">Nascimento</label><br>");
//            s+=("<input type=\"date\" id=\"nascimento\" name=\"nascimento\" "
//                    + "value=\"" + aluno.getNascimento() + "\" ><br><br>");
//            s+=("<input type=\"submit\" value=\"Enviar\" >");
//            s+=("<input type=\"submit\" formaction=\"ListarAlunosServlet\" value=\"Cancelar\">");
//            s+=("</form>");
//            s+=("</form>");

    }
    
    
}
