/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.junit.test;

import com.rave.Refund;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class RefundTestCase {
    @Test
    public void test() throws JSONException{
      
       Refund rf=new Refund();
       
       rf.setRef("FLW-MOCK-dcd2cd407f37649b04eb1342247e0bf6");
        
       
        JSONObject response=rf.refund();
      
        if(response.get("status").equals("success")){
            assertEquals(response.get("status"),"success");
          //  System.out.println(response);
           }else{
           
            assertEquals(response.get("status"),"error");
           // System.out.println("Refund not successful");
         //   System.out.println(response);
           }
       
     
    }
}
