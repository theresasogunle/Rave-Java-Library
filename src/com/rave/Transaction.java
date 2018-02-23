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
public class Transaction {
    ApiConnection apiConnection;
    //requery all failed transactions
    public JSONObject verifyTransactionRequery(String flw_ref){   
     this.apiConnection = new ApiConnection(Endpoints.VERIFY_TRANSACTION_ENDPOINT);
       ApiQuery api= new ApiQuery();
      Keys key= new Keys();
   
        try {
            key.initializeKeys();
        } catch (FileNotFoundException e) {
            System.out.print("Required Keys.json file could not be found.");
            e.printStackTrace();
        }
      String secret_key=key.SECRET_KEY;
      api.putParams("flw_ref", flw_ref);
      api.putParams("SECKEY", secret_key);
      
      
    
    return this.apiConnection.connectAndQuery(api);
    }
    
    public JSONObject verifyTransactionXquery(String txref,String flwref,String last_attempt,String only_successful){   
     
        this.apiConnection = new ApiConnection(Endpoints.VERIFY_XQUERY_ENDPOINT);
       ApiQuery api= new ApiQuery();
      Keys key= new Keys();
     
        try {
            key.initializeKeys();
        } catch (FileNotFoundException e) {
            System.out.print("Required Keys.json file could not be found.");
            e.printStackTrace();
        }
      String secret_key=key.SECRET_KEY;
      api.putParams("txref", txref);
      api.putParams("flwref", flwref);
      api.putParams("SECKEY", secret_key);
      api.putParams("last_attempt", last_attempt);
      api.putParams("only_successful", only_successful);
      
      
      
    
      return this.apiConnection.connectAndQuery(api);
    }
    
}
