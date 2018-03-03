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
       
          IntegrityChecksum ch=new IntegrityChecksum();
          
     
     
       
           ch.setAmount("20")
            .setPayment_method("both")
            .setCustom_description("Pay Internet")
            .setCustom_logo("http://localhost/payporte-3/skin/frontend/ultimo/shoppy/custom/images/logo.svg")
            .setCountry("NG")
            .setCurrency("NGN")
            .setCustomer_email( "user@example.com")
            .setCustomer_firstname("Temi")
            .setCustomer_lastname("Adelewa")
            .setCustomer_phone("234099940409")
            .setTxref("MG-CKSKKHH");
       
          String hash= ch.integrityChecksum();
           
           
          System.out.println(hash);
       

    }
}
