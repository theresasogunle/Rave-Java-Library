/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.theresasogunle;

import static com.github.theresasogunle.Encryption.encryptData;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class Polling {
          ApiConnection apiConnection;
      final private Endpoints ed=new Endpoints();
          Encryption e=new Encryption();
          RaveConstant key=new RaveConstant();
  
  
    //if timeout, start polling
     /**
     * 
     *@param json
     * @throws JSONException
     * @return JSONObject
     */
    public JSONObject handleTimeoutCharge(JSONObject json){
      this.apiConnection = new ApiConnection(ed.getChargeTimeoutEndpoint());
        JSONObject tcharge= null;
 
        String message= json.toString();
        
        String encrypt_secret_key=Encryption.getKey( RaveConstant.SECRET_KEY);
        String client= encryptData(message,encrypt_secret_key);
      
        String alg="3DES-24";
     
        ApiQuery api=new ApiQuery();
        
        api.putParams("PBFPubKey", RaveConstant.PUBLIC_KEY);

        api.putParams("client", client);

        api.putParams("alg", alg);
      
        tcharge=  this.apiConnection.connectAndQuery(api);
       
        return tcharge;

    }
     /**
     * 
     * @param transaction_reference
     * @param otp 
     * @return String
     */
    public JSONObject validateCardChargeTimeout(String transaction_reference,String otp){
       
        this.apiConnection = new ApiConnection(ed.getValidateCardChargeTimeoutEndpoint());
         ApiQuery api=new ApiQuery();
        
        api.putParams("PBFPubKey",RaveConstant.PUBLIC_KEY);
        api.putParams("transaction_reference", transaction_reference);
    
        api.putParams("otp", otp);

        return this.apiConnection.connectAndQuery(api);
    }
    
    
      /**
     * 
     * @param transaction_reference
     * @param otp 
     * @return String
     */
    public JSONObject validateAccountChargeTimeout(String transaction_reference,String otp){
       
        this.apiConnection = new ApiConnection(ed.getValidateAccountChargeTimeoutEndpoint());
         ApiQuery api=new ApiQuery();
        
        api.putParams("PBFPubKey",RaveConstant.PUBLIC_KEY);
        api.putParams("transaction_reference", transaction_reference);
    
        api.putParams("otp", otp);

        return this.apiConnection.connectAndQuery(api);
    }
    
    

  
    
}
