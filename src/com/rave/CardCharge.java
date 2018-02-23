/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import java.awt.Desktop;
import java.net.URI;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class CardCharge {
    
    Endpoints ed=new Endpoints();
    ApiConnection apiConnection;
    Keys key=new Keys();
    /**
 *
 * @param encrypted_message
 * @return JSONObject
 */
    //charge visa,mastercard,intl and verve cards
     public JSONObject chargeCard(String encrypted_message){
        Charge ch=new Charge();
        
        return ch.charge(encrypted_message);
   
    
    }
      /*
    if AuthMode::"PIN"
    @params public_key, transaction reference(flwRef),OTP 
    */
    public JSONObject validateCardCharge(String transaction_reference,String otp){
     
        this.apiConnection = new ApiConnection(ed.getValidateChargeEndPoint());
      
        ApiQuery api=new ApiQuery();
        
        api.putParams("PBFPubKey",key.getPublicKey());
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
