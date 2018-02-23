/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import java.awt.Desktop;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;
import static com.rave.Encryption.encryptData;
import static com.rave.Encryption.getKey;
import java.io.FileNotFoundException;



/**
 *
 * @author Theresa
 */
public class CardCharge {
    
    ApiConnection apiConnection;
    
   
    //for local mastercards and verve cards containing pin suggested_auth: "PIN"
    public JSONObject chargeForMasterAndVerve(String cardno,String currency,String country,String cvv,String amount, String expiryyear,String expirymonth,
           String suggested_auth, String pin,String email, String IP,String txRef, String device_fingerprint){
        
          this.apiConnection = new ApiConnection(Endpoints.CARD_CHARGE_ENDPOINT);
          
        JSONObject obj = new JSONObject();
        Keys key= new Keys();
        
        try {
            key.initializeKeys();
        } catch (FileNotFoundException e) {
            System.out.print("Required Keys.json file could not be found.");
            e.printStackTrace();
        }
        String public_key=key.PUBLIC_KEY;
          System.out.println(public_key);
        try{
       obj.put("PBFPubKey", public_key);
       obj.put("cardno",cardno);
       obj.put("currency",currency);
       obj.put("country",country);
       obj.put("cvv",cvv);
       obj.put("amount",amount);
       obj.put("expiryyear",expiryyear);
       obj.put("expirymonth",expirymonth);
       obj.put("suggested_auth",suggested_auth);
       obj.put("pin",pin);
       obj.put("email",email);
       obj.put("IP",IP);
       obj.put("txRef",txRef);
       obj.put("device_fingerprint",device_fingerprint);
        
        }catch(JSONException ex){}
        
       String message= obj.toString();
       //API Parameters
       String secret_key=key.SECRET_KEY;
        System.out.println(secret_key);
       String encrypt_secret_key=getKey(secret_key);
       String encrypted_message= encryptData(message,encrypt_secret_key);
       String alg="3DES-24";
     
        ApiQuery api=new ApiQuery();
        api.putParams("PBFPubKey", public_key);
        api.putParams("client", encrypted_message);
        api.putParams("alg", alg);
      
       System.out.println("Succesful");
      
        
        return this.apiConnection.connectAndQuery(api);
    }
   
  
      //for localVisa cards and international cards with redirect url and without pin
    public JSONObject chargeForVisaAndIntl(String cardno,String currency,String country,String cvv,String amount, String expiryyear,String expirymonth,
           String email, String IP,String txRef, String device_fingerprint,String redirectUrl){
        
          this.apiConnection = new ApiConnection(Endpoints.CARD_CHARGE_ENDPOINT);
          
        JSONObject obj = new JSONObject();
        Keys key= new Keys();
        try {
            key.initializeKeys();
        } catch (FileNotFoundException e) {
            System.out.print("Required Keys.json file could not be found.");
            e.printStackTrace();
        }
        String public_key=key.PUBLIC_KEY;
        System.out.println(public_key);
        try{
       obj.put("PBFPubKey", public_key);
       obj.put("cardno",cardno);
       obj.put("currency",currency);
       obj.put("country",country);
       obj.put("cvv",cvv);
       obj.put("amount",amount);
       obj.put("expiryyear",expiryyear);
       obj.put("expirymonth",expirymonth);
      // obj.put("pin", pin);
       obj.put("email",email);
       obj.put("IP",IP);
       obj.put("txRef",txRef);
       obj.put("device_fingerprint",device_fingerprint);
       obj.put("redirect_url", redirectUrl);
        
        }catch(JSONException ex){}
        
       String message= obj.toString();
       
       String secret_key=key.SECRET_KEY;
       String encrypt_secret_key=getKey(secret_key);
       String encrypted_message= encryptData(message,encrypt_secret_key);
       String alg="3DES-24";
     
       ApiQuery api=new ApiQuery();
       api.putParams("PBFPubKey", public_key);
       api.putParams("client", encrypted_message);
       api.putParams("alg", alg);
       System.out.println("Succesful");
       /*
       There is a space between the string in the auturl thats why this wont work,
       Once it returns json, pass it manually to the method validateCardChargeVB
     try{
       JSONObject response= this.apiConnection.connectAndQuery(api).optJSONObject("data");
       String authUrl=response.getString("authurl");
       validateCardChargeVB(authUrl);
     }catch(Exception e){}
      */
     return this.apiConnection.connectAndQuery(api);
        
        
    }
    
    
    /*
    if AuthMode::"PIN"
    @params public_key, transaction reference,OTP 
    */
    public JSONObject validateCardCharge(String transaction_reference,String otp){
     
        this.apiConnection = new ApiConnection(Endpoints.CARD_VALIDATE_ENDPOINT);
      
        ApiQuery api=new ApiQuery();
        Keys key= new Keys();
        try {
            key.initializeKeys();
        } catch (FileNotFoundException e) {
            System.out.print("Required Keys.json file could not be found.");
            e.printStackTrace();
        }
        String public_key=key.PUBLIC_KEY;
        api.putParams("PBFPubKey", public_key);
        api.putParams("transaction_reference", transaction_reference);
        api.putParams("otp", otp);
       System.out.println("Succesful");
  
       
        return this.apiConnection.connectAndQuery(api);
    }
    
    /*
    if AuthMode::"VBSECURE"or "AVS_VBVSECURECODE"
    @params authUrl This requires that you copy the authurl returned in the response
    and paste it in the argument and it opens a small window for card validation
    */
    public void validateCardChargeVB(String authUrl){
     
      if (Desktop.isDesktopSupported()) {
          try{
    Desktop.getDesktop().browse(new URI(authUrl));
          }catch(Exception e){}
            }
   
    
    }
   
}
