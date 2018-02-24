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
    private Keys key=new Keys();
    Endpoints end= new Endpoints();
   public String txref,flwref;
    
    //requery all failed transactions

    public JSONObject verifyTransactionRequery(){   

      this.apiConnection = new ApiConnection(end.getVerifyEndPoint());
      ApiQuery api= new ApiQuery();
     
      api.putParams("flw_ref", flwref);
      api.putParams("SECKEY",key.getSecretKey() );
    
      return this.apiConnection.connectAndQuery(api);
    }
    

    public JSONObject verifyTransactionXrequery(){   
     
      this.apiConnection = new ApiConnection(end.getVerifyXrequeryEndPoint());

      ApiQuery api= new ApiQuery();
      
      api.putParams("txref", txref);
      api.putParams("flwref", flwref);
      api.putParams("SECKEY", key.getSecretKey());
      api.putParams("last_attempt", 1);
      api.putParams("only_successful", 1);

      return this.apiConnection.connectAndQuery(api);
    }
    
}
