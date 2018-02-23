/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ravejava;

import org.json.JSONException;
import org.json.JSONObject;
import static ravejava.Encryption.encryptData;
import static ravejava.Encryption.getKey;

/**
 *
 * @author Theresa
 */
public class PreAuthorization {
   ApiConnection apiConnection;
   
  
  
   public JSONObject preAuthorizeCard(String cardno,String charge_type,String cvv,String expirymonth,String expiryyear,String currency,String country,String amount,
            String email,String phonenumber,String firstname,String lastname,String IP,String txRef,String redirect_url,String device_fingerprint){
       
      this.apiConnection = new ApiConnection(Endpoints.CARD_CHARGE_ENDPOINT);
      JSONObject obj = new JSONObject();
       Keys key= new Keys();
        key.initializeKeys();
        
      //preauthorization requires special public key
        String public_key="FLWPUBK-8cd258c49f38e05292e5472b2b15906e-X ";
         try{  
       obj.put("PBFPubKey", public_key);
       obj.put("cardno",cardno);
       obj.put("charge_type",charge_type);
       obj.put("cvv",cvv);
       obj.put("expirymonth",expirymonth);
       obj.put("expiryyear",expiryyear);
       obj.put("currency",currency);
       obj.put("country",country);
       obj.put("amount",amount);
       obj.put("email",email);
       obj.put("phonenumber",phonenumber);
       obj.put("firstname",firstname);
       obj.put("lastname",lastname);
       obj.put("IP",IP);
       obj.put("txRef",txRef);
       obj.put("redirect_url", redirect_url);
       obj.put("device_fingerprint",device_fingerprint);
     //  obj.put("passcode", passcode);
        }catch(JSONException ex){System.out.println("Couldnt get a parameter");}
      String message= obj.toString();
       //preauth special secret key
       String secret_key=" FLWSECK-c51891678d48c39eff3701ff686bdb69-X";
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
   
   public JSONObject capture(String flwRef){
      this.apiConnection = new ApiConnection(Endpoints.CAPTURE_ENDPOINT);
      ApiQuery api= new ApiQuery();
      Keys key= new Keys();
      key.initializeKeys();
      //preauth special secret key
      String secret_key=" FLWSECK-c51891678d48c39eff3701ff686bdb69-X";
      api.putParams("flwRef", flwRef);
      api.putParams("SECKEY", secret_key);
      
    
      return this.apiConnection.connectAndQuery(api);
   }
   
   public JSONObject refundOrVoid(String ref,String action){
   this.apiConnection = new ApiConnection(Endpoints.REFUNDVOID_ENDPOINT);
    ApiQuery api= new ApiQuery();
      Keys key= new Keys();
      key.initializeKeys();
      //preauth special secret key
      String secret_key=" FLWSECK-c51891678d48c39eff3701ff686bdb69-X";
      api.putParams("ref", ref);
      api.putParams("action", action);
      api.putParams("SECKEY", secret_key);
    
      return this.apiConnection.connectAndQuery(api);
   
   }
}
