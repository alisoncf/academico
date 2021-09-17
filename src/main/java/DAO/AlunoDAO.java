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
import model.Aluno;
import util.Config;


public class AlunoDAO {

    public void Gravar(Aluno aluno) {
        try {
            ConectaBD bd = new ConectaBD();
            String SQL = "Insert into Aluno(email,nome,nascimento)values("
                    + "'" + aluno.getEmail() + "',"
                    + "'" + aluno.getNome() + "',"
                    + "'" + aluno.getNascimento() + "')";
            bd.executa(SQL);
            bd.fecha();
        } catch (Exception ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Alterar(Aluno aluno) {
        try {
            ConectaBD bd = new ConectaBD();
            String SQL = "update Aluno set "
                    + "email='" + aluno.getEmail() + "',"
                    + "nome='" + aluno.getNome() + "',"
                    + "nascimento='" + aluno.getNascimento() + "' "
                    + " where id=" + aluno.getId();
            bd.executa(SQL);
            bd.fecha();
        } catch (Exception ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Excluir(Aluno aluno) {
        try {
            ConectaBD bd = new ConectaBD();
            String SQL = "delete from aluno "
                    + " where id=" + aluno.getId();
            bd.executa(SQL);
            bd.fecha();
        } catch (Exception ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Excluir(String id) {
        try {
            ConectaBD bd = new ConectaBD();
            String SQL = "delete from aluno "
                    + " where id=" + id;
            bd.executa(SQL);
            bd.fecha();
        } catch (Exception ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Aluno> ListaAlunos(String keyWord) {
        List<Aluno> lista = new ArrayList<>();
        ConectaBD bd = new ConectaBD();
        String SQL = "select * from aluno"
                + " where nome like '" + keyWord + "%'"
                + " order by nome";
        try {
            ResultSet r = bd.getResultset(SQL);
            while (r.next()) {
                Aluno a = new Aluno(r.getInt("id"), r.getString("nome"),
                        r.getString("email"), r.getString("nascimento"));
                lista.add(a);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        bd.fecha();

        return lista;
    }

    public Aluno getAlunoById(int id){
     List<Aluno> lista = new ArrayList<>();
        Aluno aluno = new Aluno();
        ConectaBD bd = new ConectaBD();
        String SQL = "select * from aluno "
                + " where id ='" + id + "%'";
                
        try {
            ResultSet r = bd.getResultset(SQL);
            while (r.next()) {
                 aluno = new Aluno(r.getInt("id"), r.getString("nome"),
                        r.getString("email"), r.getString("nascimento"));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        bd.fecha();

        return aluno;
    
    
    }
    
}
