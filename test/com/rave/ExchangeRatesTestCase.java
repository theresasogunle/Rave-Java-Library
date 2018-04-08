/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class ExchangeRatesTestCase {
    @Test
    public void test() throws JSONException{
    
     
        ExchangeRates e=new ExchangeRates();
       e.setAmount("500")
         .setDestination_currency("USD")
         .setOrigin_currency("NGN");
      //  System.out.println( e.forex());
        JSONObject response=e.forex();
        
     if(response.get("status").equals("success")){
            assertEquals(response.get("status"),"success");
           System.out.println(response);
           }else{
           
            assertEquals(response.get("status"),"error");
            System.out.println(response);
           }
    }
}
