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

          ch.setOtp("12345");
         ch.setTransaction_reference("FLW-MOCK-XXXXXXXXXXXXXXXXXXXXXXX");
         JSONObject validateCharge=ch.validateCardCharge();
     

      
    }
}
