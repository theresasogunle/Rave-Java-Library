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
public class Refund {
    ApiConnection apiConnection;
    public JSONObject refund(String ref){
          this.apiConnection = new ApiConnection(Endpoints.REFUND_ENDPOINT);
      ApiQuery api= new ApiQuery();
      Keys key= new Keys();
     
        try {
            key.initializeKeys();
        } catch (FileNotFoundException e) {
            System.out.print("Required Keys.json file could not be found.");
            e.printStackTrace();
        }
      String secret_key=key.SECRET_KEY;
      api.putParams("ref", ref);
      api.putParams("seckey", secret_key);
      
   
      return this.apiConnection.connectAndQuery(api);
    
    }
}
