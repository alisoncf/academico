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
import model.Usuario;
import util.Config;

/**
 *
 * @author cgpre
 */
public class UsuarioDAO {

    private Usuario usuario;

    public UsuarioDAO() {
        this.usuario = usuario;
    }

    public boolean VerificaSenha(String senha) {
        ConectaBD bd = new ConectaBD();
        try {
            ResultSet rs = bd.getResultset("select senha from Usuario where email=" + usuario.getEmail());
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    public void Gravar() {
        try {
            ConectaBD bd = new ConectaBD();
            
            String SQL = "Insert into Aluno(email,nome,senha)values("
                    + "'" + usuario.getEmail() + "',"
                    + "'" + usuario.getNome() + "',"
                    + "'aes_ecrypt(" + usuario.getSenha() + "','" + util.Config.chaveMD5 + "')";
            bd.executa(SQL);
            bd.fecha();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Alterar() {
        try {
            ConectaBD bd = new ConectaBD();
            String sql = "update usuario set ";
            
            sql += "nome='" + usuario.getNome() + "' ";
            
            if(this.usuario.getSenha()!=null){
                sql+= ",senha=aes_ecrypt(" + usuario.getSenha() + "','" + util.Config.chaveMD5 + "')";
                
            }
            
            sql+= " where email='" + usuario.getEmail() + "'";
            bd.executa(sql);
            bd.fecha();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Excluir() {
        try {
            ConectaBD bd = new ConectaBD();
            String SQL = "delete from usuario "
                    + " where email=" + this.usuario.getEmail();
            bd.executa(SQL);
            bd.fecha();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Excluir(String email) {
        try {
            ConectaBD bd = new ConectaBD();
            String SQL = "delete from usuario "
                    + " where id=" + email;
            bd.executa(SQL);
            bd.fecha();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> ListaUsuarios(String keyWord) {
        List<Usuario> lista = new ArrayList<>();
        ConectaBD bd = new ConectaBD();
        String SQL = "select * from usuario"
                + " where nome like '" + keyWord + "%'"
                + " order by nome";
        try {
            ResultSet r = bd.getResultset(SQL);
            while (r.next()) {
                Usuario a = new Usuario(r.getString("email"), r.getString("nome"));
                lista.add(a);
            }
        } catch (Exception e) {
        }

        bd.fecha();

        return lista;
    }

}
