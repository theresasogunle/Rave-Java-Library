/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.junit.test;

import com.jayway.jsonpath.Configuration;
import com.rave.AccountCharge;


import com.rave.Encryption;



import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


/**
 *
 * @author Theresa
 */
public class AccountChargeTest {
       
      JSONObject json= new JSONObject();
       AccountCharge ch= new AccountCharge();
       Encryption e=new Encryption();
      
    @Test  
    public void testAccountCharge() throws JSONException{  
          ch.setAccountnumber("0690000031");
            ch.setAccountbank("044");
            ch.setAmount("1000");
            ch.setCountry("NG");
            ch.setCurrency("NGN");
            ch.setLastname("Theresa");
            ch.setIP("1.3.4.4");
            ch.setPayment_type("account");
            ch.setTxRef("MX-678DH");
            ch.setEmail("sogunledolapo@gmail.com");
          
          
           JSONObject result=ch.chargeAccount();
          /*
           if(result.get("status").equals("success")){
            assertEquals(result.get("status"),"success");
          //  System.out.println(result);
           }else{
           
            assertEquals(result.get("status"),"error");
        //    System.out.println(result);
           }
           */
           
      
    }
    /*
        @Test
        public void verifyEncryption()throws JSONException{

        Encryption e= new Encryption();
        String encrypted_message= e.encryptParameters(json);

        Object doc = Configuration.defaultConfiguration().jsonProvider().parse(json.toString());

         assertTrue("expected client encrypted message", encrypted_message.equals(e.encryptParameters(json)));
         assertEquals("expected client encrypted message",encrypted_message,e.encryptParameters(json));


        }
    */
    @Test
    public void verifyAccountValidation()throws JSONException{ 
      
        
        ch.setTransaction_reference("ACHG-1520028650995");
        ch.setOtp("12345"); 
        /*
        JSONObject response=ch.validateAccountCharge();
       if(response.get("status").equals("success")){
            assertEquals(response.get("status"),"success");
          //  System.out.println(response);
           }else{
           
            assertEquals(response.get("status"),"error");
           //System.out.println("Validation not successful");
            //System.out.println(response);
           }
       
      */
     
           
    }
     

}
