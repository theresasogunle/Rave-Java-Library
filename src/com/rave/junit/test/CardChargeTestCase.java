/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.junit.test;

import com.rave.CardCharge;
import com.rave.Encryption;
import com.rave.Polling;

import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class CardChargeTestCase {
    
     JSONObject api=new JSONObject();
       Encryption encryption=new Encryption();
       CardCharge ch=new CardCharge();
       
    @Test
    public void testCardCharge() throws JSONException{
       ch.setCardno("4187427415564246");
       ch.setCvv("828");
       ch.setCurrency("NGN");
       ch.setCountry("NG");
       ch.setAmount("9000");
       ch.setExpiryyear("19");
       ch.setExpirymonth("09");
       ch.setEmail("sogunledolapo@gmail.com");
       ch.setIP("103.238.105.185");
       ch.setTxRef("MXX-ASC-4578");
       ch.setDevice_fingerprint("69e6b7f0sb72037aa8428b70fbe03986c");
     
      
         //for master card and verve
       ch.setPin("3310");
       ch.setSuggested_auth("PIN");
       JSONObject charge= ch.chargeMasterAndVerveCard();
       
       //for visa and intl cards
        ch.setRedirect_url("http://www.google.com");
        JSONObject chargevisa=ch.chargeVisaAndIntl();
        
        if(chargevisa.getString("status").equals("success")){
        assertEquals(charge.get("status"),"success");
       // System.out.println(charge);
        }else
       assertEquals(charge.get("status"),"error");
 
    }
    
    
    @Test
    public void verifyCardValidation()throws JSONException{
      
         ch.setOtp("12345");
         ch.setTransaction_reference("FLW-MOCK-75dd012dc6c6b58807d69d0e89432e9f");
         JSONObject validateCharge=ch.validateCardCharge();
     /*
         
        if(validateCharge.get("status").equals("success")){
                assertEquals(validateCharge.get("status"),"success");
                System.out.println("Validation successful");
                System.out.println(validateCharge);
        }else
        {
                assertEquals(validateCharge.get("status"),"error");
                System.out.println(validateCharge);
                System.out.println("Validation not successful!");
        }
  
          */ 
       //for visa and intl cards
       
       ch.setAuthUrl("");
       ch.validateCardChargeVB();
               
    //  System.out.println(resp);


}
      
}
