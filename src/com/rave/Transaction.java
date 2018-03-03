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
    private Keys key=new Keys();
    Endpoints end= new Endpoints();
   private String  flwref, txRef;
    
    //requery all failed transactions

    public JSONObject verifyTransactionRequery(){   

      this.apiConnection = new ApiConnection(end.getVerifyEndPoint());
      ApiQuery api= new ApiQuery();
      api.putParams("txref", this.getTxRef());
      api.putParams("flw_ref", this.getFlwref());
      api.putParams("SECKEY",key.getSecretKey() );
    
      return this.apiConnection.connectAndQuery(api);
    }
    

    public JSONObject verifyTransactionXrequery(){   
     
      this.apiConnection = new ApiConnection(end.getVerifyXrequeryEndPoint());

      ApiQuery api= new ApiQuery();
      
      api.putParams("txref", this.getTxRef());
      api.putParams("txref", this.getTxRef());
      api.putParams("SECKEY", key.getSecretKey());
      api.putParams("last_attempt", 1);
      api.putParams("only_successful", 1);

      return this.apiConnection.connectAndQuery(api);
    }

    /**
     * @return the flwref
     */
    public String getFlwref() {
        return flwref;
    }

    /**
     * @param flwref the flwref to set
     */
    public Transaction setFlwref(String flwref) {
        this.flwref = flwref;
        return this;
    }

    /**
     * @return the txRef
     */
    public String getTxRef() {
        return txRef;
    }

    /**
     * @param txRef the txRef to set
     */
    public Transaction setTxRef(String txRef) {
        this.txRef = txRef;
        return this;
    }
    
    
   
}
