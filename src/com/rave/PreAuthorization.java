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
  public String flwref,action;
  Keys key=new Keys();
  /*
  NB: For Preauth payment please use the keys below:
| Public Key | FLWPUBK-8cd258c49f38e05292e5472b2b15906e-X |
| Secret Key | FLWSECK-c51891678d48c39eff3701ff686bdb69-X |

    Preauth payments is based on approval per merchant,
  and is not open to accounts except approval to use these payment method is given.
  */
   public JSONObject preAuthorizeCard(String client){
       
      this.apiConnection = new ApiConnection(end.getChargeEndPoint());
     
      
      //preauthorization requires special public key
      String public_key="FLWPUBK-8cd258c49f38e05292e5472b2b15906e-X ";
      //else us the normal public key
     //  String public_key=key.getPublicKey();
       String alg="3DES-24";
       
       ApiQuery api=new ApiQuery();
         
        api.putParams("PBFPubKey", public_key);
        api.putParams("client", client);
        api.putParams("alg", alg);
        System.out.println("Succesful");
       
       
          return this.apiConnection.connectAndQuery(api);
   }
   
   public JSONObject capture(){
      this.apiConnection = new ApiConnection(end.getCaptureEndPoint());
      ApiQuery api= new ApiQuery();
    
      String secret_key="FLWSECK-c51891678d48c39eff3701ff686bdb69-X";
     // String secret_key=key.getSecretKey();
      api.putParams("flwRef", flwref);
      api.putParams("SECKEY", secret_key);
      
    
      return this.apiConnection.connectAndQuery(api);
   }
   
   public JSONObject refundOrVoid(){
   this.apiConnection = new ApiConnection(end.getRefundOrVoidEndPoint());
    ApiQuery api= new ApiQuery();
     String secret_key="FLWSECK-c51891678d48c39eff3701ff686bdb69-X";
     // String secret_key=key.getSecretKey();
      api.putParams("ref", flwref);
      api.putParams("action", action);
      api.putParams("SECKEY", secret_key);
    
      return this.apiConnection.connectAndQuery(api);
   
   }
}
