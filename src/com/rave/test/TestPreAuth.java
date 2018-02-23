/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.Encryption;
import com.rave.PreAuthorization;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class TestPreAuth {
    public static void main(String[] args){
     JSONObject api=new JSONObject();
       Encryption encryption=new Encryption();
       PreAuthorization ch=new PreAuthorization();
       
       //card charge
       try{
       
  api.put("cardno", "5438898014560229");
  api.put("charge_type","preauth");
 api.put("cvv", "812");
  api.put("expirymonth", "08");
  api.put("expiryyear","20");
 api.put( "currency", "NGN");
  api.put("country", "NG");
  api.put("amount", "100");
  api.put("email", "user@example.com");
  api.put("phonenumber", "08056552980");
  api.put("firstname", "user");
  api.put("lastname", "example");
  api.put("IP", "40.198.14");
  api.put("txRef", "MXX-ASC-4578");
  api.put("redirect_url", "https://rave-web.herokuapp.com/receivepayment");
  api.put("device_fingerprint", "69e6b7f0b72037aa8428b70fbe03986c");
       
       }catch(Exception ex){}
       String encrypted_message= encryption.encryptParameters(api);
       
       
       JSONObject charge=ch.preAuthorizeCard(encrypted_message);
       
       JSONObject capture=ch.capture("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
       JSONObject refundOrVoid=ch.refundOrVoid("FLW-MOCK-d310263f5f73e51d01e6dab32c893679","refund");
       
       
       System.out.println(charge);
    } 
}
