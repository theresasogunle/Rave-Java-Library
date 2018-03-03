/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.junit.test;

import com.rave.AccountCharge;


import com.rave.Encryption;



import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 *
 * @author Theresa
 */
public class AccountChargeTest {
       
      JSONObject json= new JSONObject();
       AccountCharge ch= new AccountCharge();
       Encryption e=new Encryption();
      
    @Test  
    public void testAccountCharge() throws JSONException{  
          ch.setAccountnumber("0690000031")
            .setAccountbank("044")
            .setAmount("1000")
            .setCountry("NG")
            .setCurrency("NGN")
            .setLastname("Theresa")
            .setIP("1.3.4.4")
            .setTxRef("MX-678DH")
            .setEmail("sogunledolapo@gmail.com");
          
          
             JSONObject result=ch.chargeAccount();
             assertEquals(result.get("status"),"success");
           //polling
            JSONObject poll=ch.chargeAccount(true);
            assertEquals(poll.get("status"),"success");
            
          //  System.out.println(val);
          /*
           if(result.get("status").equals("success")){
            assertEquals(result.get("status"),"success");
          //  System.out.println(result);
           }else{
           
            assertEquals(result.get("status"),"error");
        //    System.out.println(result);
           }
           */
           
      
    }
  
    @Test
    public void verifyAccountValidation()throws JSONException{ 
      
        
        ch.setTransaction_reference("ACHG-1520028650995")
          .setOtp("12345"); 
        //for polling
        JSONObject val=ch.validateAccountCharge(true);
        //without polling
        JSONObject validate=ch.validateAccountCharge();
        
        /*
       if(validate.get("status").equals("success")){
            assertEquals(validate.get("status"),"success");
          //  System.out.println(response);
           }else{
           
            assertEquals(validate.get("status"),"error");
           //System.out.println("Validation not successful");
            //System.out.println(response);
           }
       
      */
     
           
    }
     

}
