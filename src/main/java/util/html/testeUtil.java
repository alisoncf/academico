/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.html;

/**
 *
 * @author Administrador
 */
public class testeUtil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Form f = new Form("frm1", "get", "www.form");
        
        Input i = new Input("nome", "nome","text","Nome:",40,true,"Digite aqui seu nome");
        f.addInput(i);
        
        i = new Input("cmdenviar", "cmdenviar",  "submit",  "", 0, true, "Enviar", "www.google.com.br");
        f.addInput(i);
        
        System.out.println(f.getTag());
    }
    
}
