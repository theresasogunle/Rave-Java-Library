/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.junit.test;

import com.rave.Fees;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class FeesTestCase {
    @Test
    public void Test() throws JSONException{
    
        Fees fee= new Fees();
          fee.setAmount("500")
              .setCard6("829222")
              .setCurrency("NGN");
        JSONObject response=fee.getFees();
        JSONObject response2=fee.getFeesForCard6();
       assertEquals(response.get("status"),"success");
        
        

}
}
