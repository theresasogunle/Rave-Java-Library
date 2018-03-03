/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.junit.test;

import com.rave.IntegrityChecksum;
import com.rave.Keys;
import java.util.HashMap;
import org.json.JSONException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class IntegrityChecksumTestCase {
    Keys key=new Keys();
    @Test
    public void test() throws JSONException{
    
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
      
             assertEquals(hash,ch.integrityChecksum());
       //   System.out.println(hash);
       
    }
}
