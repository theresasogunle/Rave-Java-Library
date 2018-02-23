/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;


import com.rave.AccountCharge;
import com.rave.Encryption;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class TestAccountCharge {
    public static void main(String [] args){
    JSONObject api=new JSONObject();
       Encryption encryption=new Encryption();
       AccountCharge ch=new AccountCharge();
       
       //card charge
       try{
       api.put("accountnumber", "0690000004");
       api.put("accountbank", "044");
       api.put("currency", "NGN");
       api.put("country", "NG");
       api.put("amount", "6000");
       api.put("firstname", "pin");
       api.put("lastname", "pin");
       api.put("pin", "3310");
       api.put("email", "sogunledolapo@gmail.com");
       api.put("IP", "103.238.105.185");
       api.put("txRef", "MXX-ASC-4578");
       api.put("payment_type", "account");
       
       }catch(Exception ex){}
       String encrypted_message= encryption.encryptParameters(api);
    
     //  JSONObject res=ch.chargeAccount(encrypted_message);
       
      // JSONObject val=ch.validateAccountCharge("ACHG-1519428047882", "12345");
        //System.out.println(val);
    }
}
