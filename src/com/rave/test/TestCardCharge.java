/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;
import com.rave.*;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class TestCardCharge {
    public static void main(String [] args)throws JSONException{
        CardCharge ch=new CardCharge();
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
            //validate
            ch.setOtp("12345");
            ch.setTransaction_reference("FLW-MOCK-XXXXXXXXXXXXXXXXXXXXXXX");
            JSONObject validateCharge=ch.validateCardCharge();
            //if timeout, poll
            JSONObject validatepoll=ch.validateCardCharge(true);
        
     

      
    }
}
