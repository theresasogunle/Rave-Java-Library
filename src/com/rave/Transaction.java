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
public class Transaction {
    ApiConnection apiConnection;
    
    public JSONObject verifyTransaction(String flw_ref){   
     this.apiConnection = new ApiConnection(Endpoints.VERIFY_TRANSACTION_ENDPOINT);
       ApiQuery api= new ApiQuery();
      Keys key= new Keys();
      key.initializeKeys();
      String secret_key=key.SECRET_KEY;
      api.putParams("flw_ref", flw_ref);
      api.putParams("SECKEY", secret_key);
      
      
    
    return this.apiConnection.connectAndQuery(api);
    }
    
    public JSONObject verifyXqueryTransaction(String txref,String flwref,String last_attempt,String only_successful){   
     
        this.apiConnection = new ApiConnection(Endpoints.VERIFY_XQUERY_ENDPOINT);
       ApiQuery api= new ApiQuery();
      Keys key= new Keys();
      key.initializeKeys();
      String secret_key=key.SECRET_KEY;
      api.putParams("txref", txref);
      api.putParams("flwref", flwref);
      api.putParams("SECKEY", secret_key);
      api.putParams("last_attempt", last_attempt);
      api.putParams("only_successful", only_successful);
      
      
      
    
      return this.apiConnection.connectAndQuery(api);
    }
    
}
