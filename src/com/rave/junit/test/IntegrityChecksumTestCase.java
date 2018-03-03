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
      
         assertEquals(hash,ch.integrityChecksum());
       //   System.out.println(hash);
       
    }
}
