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
public class Fees {
    private ApiConnection apiConnection;
    Keys key= new Keys();
    Endpoints end= new Endpoints();
<<<<<<< HEAD
    public String amount,currency,card6;
    
    public JSONObject getFees(){   
=======
   
     
    public JSONObject getFees(String amount,String currency){   
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
      this.apiConnection = new ApiConnection(end.getFeesEndPoint());

      ApiQuery api= new ApiQuery();
      api.putParams("amount", amount);
      api.putParams("PBFPubKey", key.getPublicKey());
      api.putParams("currency", currency);
      api.putParams("ptype",2);


      return this.apiConnection.connectAndQuery(api);
    }
     /*used only when the user has entered first 6digits of their card number,
     it also helps determine international fees on the transaction if the card being used is an international card
     */
<<<<<<< HEAD
    public JSONObject getFeesForCard6(){
=======
    public JSONObject getFeesForCard6(String amount,String currency, String card6){
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
      this.apiConnection = new ApiConnection(end.getFeesEndPoint());

      ApiQuery api= new ApiQuery();
      api.putParams("amount", amount);
      api.putParams("PBFPubKey", key.getPublicKey());
      api.putParams("currency", currency);
      api.putParams("ptype",2);
      api.putParams("card6", card6);

      return this.apiConnection.connectAndQuery(api);
    }
}
