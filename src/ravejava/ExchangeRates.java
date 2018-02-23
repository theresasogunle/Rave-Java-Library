/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ravejava;

import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class ExchangeRates {
     ApiConnection apiConnection;
    public JSONObject forex(String origin_currency,String destination_currency,String amount){
          this.apiConnection = new ApiConnection(Endpoints.FOREX_ENDPOINT);
      ApiQuery api= new ApiQuery();
      Keys key= new Keys();
      key.initializeKeys();
      String secret_key=key.SECRET_KEY;
      
        //System.out.println(secret_key);
      //API PARAMETERS
      api.putParams("SECKEY", secret_key);
      api.putParams("origin_currency", origin_currency);
      api.putParams("destination_currency",  destination_currency);
      api.putParams("amount",  amount);
    
      
      return this.apiConnection.connectAndQuery(api);
    
    }
}
