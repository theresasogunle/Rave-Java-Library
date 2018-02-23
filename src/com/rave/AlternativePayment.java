/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import org.json.JSONException;
import org.json.JSONObject;
import static com.rave.Encryption.encryptData;
import static com.rave.Encryption.getKey;
import java.io.FileNotFoundException;


/**
 *
 * @author Theresa
 */
public class AlternativePayment {
    
    ApiConnection apiConnection;
  
    
    // charge customers using nigerian USSD for GTB and Zenith Bank
    public JSONObject nigerianUSSD(String accountnumber,String accountbank,String currency,String country,String payment_type,String amount,
            String email,String phonenumber,String firstname,String lastname,String IP,String txRef,String orderRef,String is_ussd,String device_fingerprint){
     
        //getting charge endpoint
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
         try{   
       obj.put("PBFPubKey", public_key);
       obj.put("accountnumber",accountnumber);
       obj.put("accountbank",accountbank);
       obj.put("currency",currency);
       obj.put("country",country);
       obj.put("payment_type", payment_type);
       obj.put("amount",amount);
       obj.put("email",email);
       obj.put("phonenumber",phonenumber);
       obj.put("firstname",firstname);
       obj.put("lastname",lastname);
       obj.put("IP",IP);
       obj.put("txRef",txRef);
       obj.put("orderRef", orderRef);
       obj.put("is_ussd", is_ussd);
       obj.put("device_fingerprint",device_fingerprint);
     //  obj.put("passcode", passcode);
        }catch(JSONException ex){System.out.println("Error!");}
      String message= obj.toString();
       
       String secret_key=key.SECRET_KEY;
       String encrypt_secret_key=getKey(secret_key);
       
       String encrypted_message= encryptData(message,encrypt_secret_key);
       
       ApiQuery api=new ApiQuery();
       
      String alg="3DES-24";
      api.putParams("PBFPubKey", public_key);
      api.putParams("client", encrypted_message);
      api.putParams("alg", alg);
      
      System.out.println("Succesful");
     
  
       
          
      return  this.apiConnection.connectAndQuery(api);
   
    
    }
    
   // charge customers using Ghana Mobile Money.
    public JSONObject ghanaMobileMoney(String currency,String country,String payment_type,String amount, String network,
            String email,String phonenumber,String firstname,String lastname,String IP,String txRef,String orderRef,String is_mobile_money_gh,String device_fingerprint){
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
         try{
             
            
       obj.put("PBFPubKey", public_key);
       obj.put("currency",currency);
       obj.put("country",country);
       obj.put("payment_type", payment_type);
       obj.put("amount",amount);
       obj.put("network",network);
       obj.put("email",email);
       obj.put("phonenumber",phonenumber);
       obj.put("firstname",firstname);
       obj.put("lastname",lastname);
       obj.put("IP",IP);
       obj.put("txRef",txRef);
       obj.put("orderRef", orderRef);
       obj.put("is_mobile_money_gh", is_mobile_money_gh);
       obj.put("device_fingerprint",device_fingerprint);
     //  obj.put("passcode", passcode);
        }catch(JSONException ex){System.out.println("Error!");}
         
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
      
      
        
          return  this.apiConnection.connectAndQuery(api);
    }
    
    // charge customers using Mpesa 
    public JSONObject kenyaMpesa(String currency,String country,String payment_type,String amount, 
            String email,String phonenumber,String firstname,String lastname,String IP,String txRef,String orderRef,String is_mpesa,String device_fingerprint){
       
        //getting charge endppoint
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
        
         try{      
       obj.put("PBFPubKey", public_key);
       obj.put("currency",currency);
       obj.put("country",country);
       obj.put("payment_type", payment_type);
       obj.put("amount",amount);
       obj.put("email",email);
       obj.put("phonenumber",phonenumber);
       obj.put("firstname",firstname);
       obj.put("lastname",lastname);
       obj.put("IP",IP);
       obj.put("txRef",txRef);
       obj.put("orderRef", orderRef);
       obj.put("is_mpesa", is_mpesa);
       obj.put("device_fingerprint",device_fingerprint);
     //  obj.put("passcode", passcode);
        }catch(JSONException ex){System.out.println("Error!");}
       
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
      
          return this.apiConnection.connectAndQuery(api);
   
    }
    
    //to requery transaction for ghana mobile money,kenya mpesa and nigerian ussd using xquery
    public JSONObject completeTransactionWithXquery(String txref,String flwref,String last_attempt,String only_successful){
     this.apiConnection = new ApiConnection(Endpoints.VERIFY_TRANSACTION_ENDPOINT);
       ApiQuery api= new ApiQuery();
      Keys key= new Keys();
    
        try {
            key.initializeKeys();
        } catch (FileNotFoundException e) {
            System.out.print("Required Keys.json file could not be found.");
            e.printStackTrace();
        }
      String secret_key=key.SECRET_KEY;
      api.putParams("txref", txref);
      api.putParams("flwref", flwref);
      api.putParams("SECKEY", secret_key);
      api.putParams("last_attempt", last_attempt);
      api.putParams("only_successful", only_successful);
   
    
    return this.apiConnection.connectAndQuery(api);
    
    }
    public JSONObject completeTransactionWithoutXquery(String flw_ref){   
     this.apiConnection = new ApiConnection(Endpoints.VERIFY_XQUERY_ENDPOINT);
       ApiQuery api= new ApiQuery();
      Keys key= new Keys();
   
        try {
            key.initializeKeys();
        } catch (FileNotFoundException e) {
            System.out.print("Required Keys.json file could not be found.");
            e.printStackTrace();
        }
      String secret_key=key.SECRET_KEY;
      api.putParams("flw_ref", flw_ref);
      api.putParams("SECKEY", secret_key);
      
      
      
      return this.apiConnection.connectAndQuery(api);
    }
}
