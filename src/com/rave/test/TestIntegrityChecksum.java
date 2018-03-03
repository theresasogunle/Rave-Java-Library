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
       
      ch.setAmount("20");
      ch.setPayment_method("both");
      ch.setCustom_description("Pay Internet");
      ch.setCustom_logo("http://localhost/payporte-3/skin/frontend/ultimo/shoppy/custom/images/logo.svg");
      ch.setCountry("NG");
      ch.setCurrency("NGN");
      ch.setCustomer_email( "user@example.com");
      ch.setCustomer_firstname("Temi");
      ch.setCustomer_lastname("Adelewa");
      ch.setCustomer_phone("234099940409");
      ch.setTxref("MG-CKSKKHH");
       
          String hash= ch.integrityChecksum();
           
           
          System.out.println(hash);
       

    }
}
