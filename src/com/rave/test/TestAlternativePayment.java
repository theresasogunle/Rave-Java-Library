/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

//import com.rave.AlternativePayment;
//import com.rave.Encryption;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class TestAlternativePayment {
    public static void main(String [] args){
    //for Nigerian ussd
    //card charge
    JSONObject api=new JSONObject();
    Encryption encryption=new Encryption();
    AlternativePayment ch=new AlternativePayment();
    try{
           //available for only zenith and GTB
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
       api.put("payment_type", "ussd");
       
       
    }catch(Exception ex){}
    String encrypted_message= encryption.encryptParameters(api);
    //for ghana mobile money
       
    try{
       api.put("orderRef", "0690000004");
       api.put("network", "MTN");
       api.put("currency", "NGN");
       api.put("country", "NG");
       api.put("amount", "6000");
       api.put("firstname", "pin");
       api.put("lastname", "pin");
       api.put("pin", "3310");
       api.put("email", "sogunledolapo@gmail.com");
       api.put("IP", "103.238.105.185");
       api.put("txRef", "MXX-ASC-4578");
       api.put("payment_type", "mobilemoneygh");
       api.put("is_mobile_money_gh", "1");
       
    }catch(Exception ex){}
    //  String encrypted_message= encryption.encryptParameters(api);
         
         //for kenya mpesa
    try{
       
       api.put("currency", "NGN");
       api.put("country", "NG");
       api.put("amount", "6000");
       api.put("firstname", "pin");
       api.put("lastname", "pin");
       api.put("pin", "3310");
       api.put("email", "sogunledolapo@gmail.com");
       api.put("IP", "103.238.105.185");
       api.put("txRef", "MXX-ASC-4578");
       api.put("payment_type", "mpesa");
       api.put("is_mpesa", "1");
       api.put("orderRef", "");
       
    }catch(Exception ex){}
    //  String encrypted_message= encryption.encryptParameters(api);
    JSONObject charge=ch.alternativePaymentCharge(encrypted_message);
       
    // JSONObject validateCharge=ch.validateCardCharge("FLW-MOCK-d310263f5f73e51d01e6dab32c893679", "12345");
       
    System.out.println(charge);
    
    }
}
