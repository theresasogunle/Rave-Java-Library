/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;


import java.io.FileNotFoundException;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class Fees {
     private ApiConnection apiConnection;
     
     
     public JSONObject getFees(String amount,String currency){   
     this.apiConnection = new ApiConnection(Endpoints.FEES_ENDPOINT);
     
     
     Keys keys= new Keys();
        try {
            keys.initializeKeys();
        } catch (FileNotFoundException e) {
            System.out.print("Required Keys.json file could not be found.");
            e.printStackTrace();
        }
     String public_key=keys.PUBLIC_KEY;
     
      ApiQuery api= new ApiQuery();
      api.putParams("amount", amount);
      api.putParams("PBFPubKey", public_key);
      api.putParams("currency", currency);
      api.putParams("ptype",2);
     
     
     return this.apiConnection.connectAndQuery(api);
   
    }
     /*used only when the user has entered first 6digits of their card number,
     it also helps determine international fees on the transaction if the card being used is an international card
     */
     public JSONObject getFeesForCard6(String amount,String currency, String card6){
      this.apiConnection = new ApiConnection(Endpoints.FEES_ENDPOINT);
    Keys keys= new Keys();
        try {
            keys.initializeKeys();
        } catch (FileNotFoundException e) {
            System.out.print("Required Keys.json file could not be found.");
            e.printStackTrace();
        }
      
     String public_key=keys.PUBLIC_KEY;
     
      ApiQuery api= new ApiQuery();
      api.putParams("amount", amount);
      api.putParams("PBFPubKey", public_key);
      api.putParams("currency", currency);
      api.putParams("ptype",2);
      api.putParams("card6", card6);
     
   
      
     return this.apiConnection.connectAndQuery(api);
   
      
     }
}