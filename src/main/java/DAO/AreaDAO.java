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
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import model.Aluno;
import model.Area;
import util.Config;


public class AreaDAO {

    public void Gravar(Area area) throws Exception {
        ConectaBD bd = new ConectaBD();
        String SQL = "Insert into Area(nome)values("
                + "'" + area.getNome() + "')";
                
        bd.executa(SQL);
        bd.fecha();
    }

    public void Alterar(Area area) throws Exception {
        ConectaBD bd = new ConectaBD();
        String SQL = "update Area set "
                + "nome='" + area.getNome() + "' "
                + " where id=" + area.getId();
        bd.executa(SQL);
        bd.fecha();
    }

    public void Excluir(Area area) throws Exception {
        ConectaBD bd = new ConectaBD();
        String SQL = "delete from Area"
                + " where id=" + area.getId();
        bd.executa(SQL);
        bd.fecha();
    }

    public void Excluir(String id) throws Exception {
        ConectaBD bd = new ConectaBD();
        String SQL = "delete from Area"
                + " where id=" + id;
        bd.executa(SQL);
        bd.fecha();
    }

    public List<Area> ListaAreas(String keyWord) {
        List<Area> lista = new ArrayList<>();
        ConectaBD bd = new ConectaBD();
        String SQL = "select * from Area"
                + " where nome like '" + keyWord + "%'"
                + " order by nome";
        try {
            ResultSet r = bd.getResultset(SQL);
            while (r.next()) {
                Area a = new Area(r.getInt("id"), r.getString("nome"));
                lista.add(a);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        bd.fecha();

        return lista;
    }

    public Area getAreaById(int id){
     List<Area> lista = new ArrayList<>();
        Area a  = new Area();
        ConectaBD bd = new ConectaBD();
        String SQL = "select * from Area"
                + " where id ='" + id + "%'";
                
        try {
            ResultSet r = bd.getResultset(SQL);
            while (r.next()) {
                 a = new Area(r.getInt("id"), r.getString("nome"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        bd.fecha();

        return a;
    
    
    }
    
}
