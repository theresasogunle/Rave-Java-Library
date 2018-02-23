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
public class ExchangeRates {
     ApiConnection apiConnection;
     Endpoints end= new Endpoints();
     Keys key=new Keys();
     /**
 *
 * @params
 * origin_currency,destination_currency , amount
 * @return JSONObject
 */
     
    public JSONObject forex(String origin_currency,String destination_currency,String amount){
        
      this.apiConnection = new ApiConnection(end.getForexEndPoint());
      ApiQuery api= new ApiQuery();
     
      //API PARAMETERS
      api.putParams("SECKEY",key.getSecretKey());
      api.putParams("origin_currency", origin_currency);
      api.putParams("destination_currency",  destination_currency);
      api.putParams("amount",  amount);
    
      
      return this.apiConnection.connectAndQuery(api);
    
    }
}
