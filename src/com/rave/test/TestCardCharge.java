/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;
import com.rave.*;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class TestCardCharge {
    public static void main(String [] args){
       JSONObject api=new JSONObject();
       Encryption encryption=new Encryption();
       CardCharge ch=new CardCharge();
       
       //card charge
       try{
       api.put("cardno", "5438898014560229");
       api.put("cvv", "789");
       api.put("currency", "NGN");
       api.put("country", "NG");
       api.put("amount", "6000");
       api.put("expiryyear", "19");
       api.put("expirymonth", "09");
       api.put("suggested_auth", "pin");
       api.put("pin", "3310");
       api.put("email", "sogunledolapo@gmail.com");
       api.put("IP", "103.238.105.185");
       api.put("txRef", "MXX-ASC-4578");
       api.put("device_fingerprint", "69e6b7f0sb72037aa8428b70fbe03986c");
       
       }catch(Exception ex){}
       String encrypted_message= encryption.encryptParameters(api);
       
       
      // JSONObject charge=ch.chargeCard(encrypted_message);
       
      // JSONObject validateCharge=ch.validateCardCharge("FLW-MOCK-d310263f5f73e51d01e6dab32c893679", "12345");
       
      //  System.out.println(validateCharge);
       



     
    }
}
