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
    
        Fees f= new Fees();
        f.setAmount("5000");
        f.setCurrency("NGN");
        f.setCard6("123453");
        
        JSONObject response=f.getFees();
        JSONObject response2=f.getFeesForCard6();
        assertEquals(response.get("status"),"success");
        
        

}
}
