/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import com.mashape.unirest.http.JsonNode;
import org.json.JSONException;
import org.json.JSONObject;
import static com.rave.Encryption.encryptData;
import static com.rave.Encryption.getKey;

/**
 *
 * @author Theresa
 */
public class Account {
    
    ApiConnection apiConnection;
   
    
     public JsonNode getAllBanks(){   
     this.apiConnection = new ApiConnection(Endpoints.BANK_ENDPOINT);
        JsonNode obj= this.apiConnection.connectAndQueryWithGet();
      
        return obj;
    }
     
    public JSONObject chargeAccount(String accountnumber,String accountbank,String currency,String country,String amount,
            String email,String phonenumber,String firstname,String lastname,String IP,String txRef,String payment_type,String device_fingerprint){
        this.apiConnection = new ApiConnection(Endpoints.CARD_CHARGE_ENDPOINT);
      JSONObject obj = new JSONObject();
       Keys key= new Keys();
       key.initializeKeys();
      
        String public_key=key.PUBLIC_KEY;
         try{    
       obj.put("PBFPubKey", public_key);
       obj.put("accountnumber",accountnumber);
       obj.put("accountbank",accountbank);
       obj.put("currency",currency);
       obj.put("country",country);
       obj.put("amount",amount);
       obj.put("email",email);
       obj.put("phonenumber",phonenumber);
       obj.put("firstname",firstname);
       obj.put("lastname",lastname);
       obj.put("IP",IP);
       obj.put("txRef",txRef);
       obj.put("payment_type", payment_type);
       obj.put("device_fingerprint",device_fingerprint);
     //  obj.put("passcode", passcode);
        }catch(JSONException ex){System.out.println("Couldnt get a parameter");}
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
    public JSONObject validateAccountCharge(String public_key,String transaction_reference,String otp){
      this.apiConnection = new ApiConnection(Endpoints.CARD_VALIDATE_ENDPOINT);
    ApiQuery api=new ApiQuery();
    
     api.putParams("PBFPubKey", public_key);
     api.putParams("transaction_reference", transaction_reference);
     api.putParams("otp", otp);
      // System.out.println("Succesful");
    
       
        return this.apiConnection.connectAndQuery(api);
    }
    
}
