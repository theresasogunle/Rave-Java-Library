/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.junit.test;

import com.rave.Transaction;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class TransactionVerificationTestCase {
   @Test
   public void Test()throws JSONException{
   boolean error=false;
    Transaction t=new Transaction();
       t.setFlwref("FLW-MOCK-d310263f5f73e51d01e6dab32c893679")
         .setTxRef("");
       
     JSONObject response=  t.verifyTransactionRequery();
     if(!error){
     assertEquals(response.get("status"),"success");
     //  System.out.println(response);
     }
     else{
      assertEquals(response.get("status"),"error");
      // System.out.println(response);
     }
         
   }
}
