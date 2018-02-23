/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;


import org.json.JSONObject;



/**
 *
 * @author Theresa
 */
public class PreAuthorization {
   ApiConnection apiConnection;
   Endpoints end=new Endpoints();
  
  
   public JSONObject preAuthorizeCard(String encrypted_message){
       
      this.apiConnection = new ApiConnection(end.getChargeEndPoint());
     
      
      //preauthorization requires special public key
      String public_key="FLWPUBK-8cd258c49f38e05292e5472b2b15906e-X ";
       
       String alg="3DES-24";
       
       ApiQuery api=new ApiQuery();
         
        api.putParams("PBFPubKey", public_key);
        api.putParams("client", encrypted_message);
        api.putParams("alg", alg);
        System.out.println("Succesful");
       
       
          return this.apiConnection.connectAndQuery(api);
   }
   
   public JSONObject capture(String flwRef){
      this.apiConnection = new ApiConnection(end.getCaptureEndPoint());
      ApiQuery api= new ApiQuery();
    
      String secret_key="FLWSECK-c51891678d48c39eff3701ff686bdb69-X";
       System.out.println(secret_key);
      api.putParams("flwRef", flwRef);
      api.putParams("SECKEY", secret_key);
      
    
      return this.apiConnection.connectAndQuery(api);
   }
   
   public JSONObject refundOrVoid(String ref,String action){
   this.apiConnection = new ApiConnection(end.getRefundOrVoidEndPoint());
    ApiQuery api= new ApiQuery();
     String secret_key="FLWSECK-c51891678d48c39eff3701ff686bdb69-X";
    
      api.putParams("ref", ref);
      api.putParams("action", action);
      api.putParams("SECKEY", secret_key);
    
      return this.apiConnection.connectAndQuery(api);
   
   }
}
