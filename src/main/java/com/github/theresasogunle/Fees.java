/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.theresasogunle;



import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class Fees {
    private ApiConnection apiConnection;
   
    Endpoints end= new Endpoints();

    private String amount;
    private String currency;
    private String card6;
     /**
    *
    * 
    * @return JSONObject
    * 
    */
    
    public JSONObject getFees(){   

      this.apiConnection = new ApiConnection(end.getFeesEndPoint());

      ApiQuery api= new ApiQuery();
      api.putParams("amount", this.getAmount());
      api.putParams("PBFPubKey",  RaveConstant.PUBLIC_KEY);
      api.putParams("currency", this.getCurrency());
      api.putParams("ptype",2);


      return this.apiConnection.connectAndQuery(api);
    }
     /*used only when the user has entered first 6digits of their card number,
     it also helps determine international fees on the transaction if the card being used is an international card
     */

    public JSONObject getFeesForCard6(){

      this.apiConnection = new ApiConnection(end.getFeesEndPoint());

      ApiQuery api= new ApiQuery();
      api.putParams("amount", this.getAmount());
      api.putParams("PBFPubKey",  RaveConstant.PUBLIC_KEY);
      api.putParams("currency", this.getCurrency());
      api.putParams("ptype",2);
      api.putParams("card6", this.getCard6());

      return this.apiConnection.connectAndQuery(api);
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public Fees setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public Fees setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * @return the card6
     */
    public String getCard6() {
        return card6;
    }

    /**
     * @param card6 the card6 to set
     */
    public Fees setCard6(String card6) {
        this.card6 = card6;
        return this;
    }
}
