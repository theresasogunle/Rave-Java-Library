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
   public String transaction_reference,otp, authUrl;
    /**
    *
<<<<<<< HEAD
    * @param client
    * @return JSONObject
    */
    //charge visa,mastercard,intl and verve cards
    public JSONObject chargeCard(String client){
        Charge ch=new Charge();
        
        return ch.charge(client);
=======
    * @param encrypted_message
    * @return JSONObject
    */
    //charge visa,mastercard,intl and verve cards
    public JSONObject chargeCard(String encrypted_message){
        Charge ch=new Charge();
        
        return ch.charge(encrypted_message);
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
        
    }

    /*
    if AuthMode::"PIN"
    @params transaction reference(flwRef),OTP 
    */
<<<<<<< HEAD
    public JSONObject validateCardCharge(){
=======
    public JSONObject validateCardCharge(String transaction_reference,String otp=""){
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
     
        this.apiConnection = new ApiConnection(ed.getValidateChargeEndPoint());
      
        ApiQuery api=new ApiQuery();
        
        api.putParams("PBFPubKey",key.getPublicKey());
        api.putParams("transaction_reference", transaction_reference);
   //  
        api.putParams("otp", otp);
<<<<<<< HEAD
       // System.out.println("Succesful");
=======
        System.out.println("Succesful");
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
       
        return this.apiConnection.connectAndQuery(api);
    }
    
    /*
    if AuthMode::"VBSECURE"or "AVS_VBVSECURECODE"
    @params authUrl This requires that you copy the authurl returned in the response
    and paste it in the argument and it opens a small window for card validation
    */
    public void validateCardChargeVB(){
     
      if (Desktop.isDesktopSupported()) {
          try{
    Desktop.getDesktop().browse(new URI(authUrl));
          }catch(Exception e){}
            }
    }
}
