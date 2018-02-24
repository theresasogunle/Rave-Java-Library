/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import com.mashape.unirest.http.JsonNode;

import org.json.JSONObject;


/**
 *
 * @author Theresa
 */
public class AccountCharge {
    
    ApiConnection apiConnection;
    Keys key = new Keys();
    Endpoints end= new Endpoints();
     
   public  String transaction_reference, otp;//to be called
   
   
    public JsonNode getAllBanks(){   
     
        Bank b=new Bank();
    
        return b.getAllBanks();
    }

    /**
    *
    * @param client
    */   
    public JSONObject chargeAccount(String client){
        Charge ch=new Charge();
        
        return ch.charge(client);
    
    }

    /**
    * 
    * @return JSONObject
    */
    public JSONObject validateAccountCharge(){
        this.apiConnection = new ApiConnection(end.getValidateChargeEndPoint());
        ApiQuery api=new ApiQuery();
        api.putParams("PBFPubKey", key.getPublicKey());
        api.putParams("transaction_reference", transaction_reference);
        api.putParams("otp", otp);    
       
        return this.apiConnection.connectAndQuery(api);
    }
    
}
