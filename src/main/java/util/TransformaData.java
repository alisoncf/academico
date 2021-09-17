/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author cgpre
 */
public class TransformaData {
    private String sData;
    private Date dData;
    public TransformaData(String data){
        try {
            this.sData=data;
            dData = new SimpleDateFormat("dd/mm/yyyy").parse(sData);
            
        } catch (ParseException ex) {
            
        }
    
    }
   
    public String getsData(){
        return this.sData;
    }
    public Date getdData(){
        return this.dData;
    }
}
