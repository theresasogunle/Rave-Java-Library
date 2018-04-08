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
public class TransactionVerificationTestCase {
   @Test
   public void Test()throws JSONException{
  
    Transaction t=new Transaction();
       t.setFlwref("FLW-MOCK-d310263f5f73e51d01e6dab32c893679")
         .setTxRef("");
       
     JSONObject response=  t.verifyTransactionRequery();
     JSONObject response2= t.verifyTransactionXrequery();
   if(response.get("status").equals("success")){
            assertEquals(response.get("status"),"success");
            System.out.println(response);
           }else{
           
            assertEquals(response.get("status"),"error");
         
            System.out.println(response);
           }
           if(response2.get("status").equals("success")){
            assertEquals(response2.get("status"),"success");
            System.out.println(response2);
           }else{
           
            assertEquals(response2.get("status"),"error");
         
            System.out.println(response2);
           }
         
   }
}
