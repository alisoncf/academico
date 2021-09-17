/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import util.Config;

public class ConectaBD {
    Connection con;
    Statement stmt;
    public ConectaBD() {
    }

    public void executa(String sql) throws Exception {
        try {

            Context envContext = new InitialContext();
            Context initContext = (Context) envContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) initContext.lookup(Config.DataSetName);
             con = ds.getConnection();
             stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e);
        }
    }

    public ResultSet getResultset(String sql) {
        try {

            Context envContext = new InitialContext();
            Context initContext = (Context) envContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) initContext.lookup(Config.DataSetName);
            con = ds.getConnection();
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void fecha() {
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
        }
    }

}
