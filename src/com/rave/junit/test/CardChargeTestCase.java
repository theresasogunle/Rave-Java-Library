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
       ch.setCardno("4187427415564246")
          .setCvv("828")
          .setCurrency("NGN")
          .setCountry("NG")
          .setAmount("9000")
          .setExpiryyear("19")
          .setExpirymonth("09")
          .setEmail("sogunledolapo@gmail.com")
          .setIP("103.238.105.185")
          .setTxRef("MXX-ASC-4578")
          .setDevice_fingerprint("69e6b7f0sb72037aa8428b70fbe03986c");
       //for master card and verve
           ch.setPin("3310")
             .setSuggested_auth("PIN");
             JSONObject charge= ch.chargeMasterAndVerveCard();
            //if timeout
            JSONObject poll=ch.chargeMasterAndVerveCard(true);
   
       //for visa and intl cards
            ch.setRedirect_url("http://www.google.com");
            JSONObject chargevisa=ch.chargeVisaAndIntl();
            //if timeout, poll
            JSONObject pollvisa=ch.chargeVisaAndIntl(true);
           
        //UNCOMMENT TO TEST
        /*
        if(chargevisa.getString("status").equals("success")){
        assertEquals(chargevisa.get("status"),"success");
         System.out.println(chargevisa);
        }else
         assertEquals(chargevisa.get("status"),"error");
        System.out.println(chargevisa);
     */
    }
    
    
    @Test
    public void verifyCardValidation()throws JSONException{
      
          //validate
            ch.setOtp("12345");
            ch.setTransactionreference("FLW-MOCK-XXXXXXXXXXXXXXXXXXXXXXX");
            JSONObject validateCharge=ch.validateCardCharge();
            //if timeout, poll
            JSONObject validatepoll=ch.validateCardCharge(true);
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
