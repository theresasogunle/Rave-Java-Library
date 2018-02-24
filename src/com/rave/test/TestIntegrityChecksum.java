/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.IntegrityChecksum;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Theresa
 */
public class TestIntegrityChecksum {
      public static void main(String [] args){
          Date d=new Date();
          IntegrityChecksum ch=new IntegrityChecksum();
          
        
       HashMap payload=new HashMap();
       
     // payload.put("PBFPubKey" ,"FLWPUBK-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-X");
      payload.put("amount" ,"20");
      payload.put("payment_method", "both");
      payload.put("custom_description","Pay Internet");
       payload.put("custom_logo","http://localhost/payporte-3/skin/frontend/ultimo/shoppy/custom/images/logo.svg");
       payload.put("country", "NG");
       payload.put("currency", "NGN");
       payload.put ("customer_email", "user@example.com");
       payload.put(  "customer_firstname", "Temi");
       payload.put("customer_lastname", "Adelewa");
       payload.put("customer_phone", "234099940409");
       payload.put( "txref","MG-"+d.getDate());
       
      String hash= ch.integrityChecksum(payload);
          System.out.println(hash);
       
       
           
           
        
       

    }
}
