/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import model.Area;
import model.Professor;
import util.Config;

public class ProfessorDAO {

    public String Gravar(Professor professor) {
        ConectaBD bd = new ConectaBD();
        String SQL = "Insert into Professor(cpf,email,nome,telefone,id_area)values("
                + "'" + professor.getCpf() + "',"
                + "'" + professor.getEmail() + "',"
                + "'" + professor.getNome() + "',"
                + "'" + professor.getTelefone() + "',"
                + "'" + professor.getArea().getId() + "')";
        try {
            bd.executa(SQL);
            bd.fecha();
            return "sucesso na operação.";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public void Alterar(Professor professor) throws Exception {
        ConectaBD bd = new ConectaBD();
        String SQL = "update Professor set "
                + "email='" + professor.getEmail() + "',"
                + "nome='" + professor.getNome() + "',"
                + "cpf='" + professor.getCpf() + "', "
                + "id_area='" + professor.getArea().getId() + "', "
                + "telefone='" + professor.getTelefone() + "' "
                + " where id=" + professor.getId();
        bd.executa(SQL);
        bd.fecha();
    }

    public void Excluir(Professor professor) throws Exception {
        ConectaBD bd = new ConectaBD();
        String SQL = "delete from professor "
                + " where id=" + professor.getId();
        bd.executa(SQL);
        bd.fecha();
    }

    public void Excluir(String id) {
        ConectaBD bd = new ConectaBD();
        String SQL = "delete from professor "
                + " where id=" + id;
        try {
            bd.executa(SQL);
        } catch (Exception ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.fecha();
    }

    public List<Professor> ListaProfessores(String keyWord) {
        List<Professor> lista = new ArrayList<>();
        ConectaBD bd = new ConectaBD();
        String SQL = "select p.*,a.nome as nome_area from professor as p inner join area as a on p.id_area=a.id "
                + " where p.nome like '" + keyWord + "%'"
                + " order by p.nome";
        try {
            ResultSet r = bd.getResultset(SQL);
            while (r.next()) {
                Professor a = new Professor(r.getInt("id"), r.getString("nome"),
                        r.getString("email"), r.getString("cpf"), r.getString("telefone"), new Area(r.getInt("id_area"), r.getString("nome_area")));
                lista.add(a);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        bd.fecha();

        return lista;
    }

    public Professor getProfessorById(int id) {
        List<Professor> lista = new ArrayList<>();
        Professor professor = new Professor();
        ConectaBD bd = new ConectaBD();
        String SQL = "select p.*,a.nome as nome_area from professor as p inner join area as a on p.id_area=a.id "
                + " where p.id ='" + id + "'";

        try {
            ResultSet r = bd.getResultset(SQL);
            while (r.next()) {
                professor = new Professor(r.getInt("id"), r.getString("nome"),
                        r.getString("email"), r.getString("cpf"), r.getString("telefone"), new Area(r.getInt("id_area"), r.getString("nome_area")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        bd.fecha();

        return professor;

    }

}
