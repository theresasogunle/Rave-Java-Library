/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.junit.test;

import com.rave.Polling;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class PollingTestCase {
    @Test
       public void testPollingAccount()throws Exception{ 
       Polling p=new Polling();
            p.setCardno("4187427415564246");
            p.setCvv("828");
            p.setAmount("1000");
            p.setCountry("NG");
            p.setCurrency("NGN");
            p.setExpiryyear("19");
            p.setExpirymonth("09");
            p.setLastname("Theresa");
            p.setIP("1.3.4.4");
            p.setRedirect_url("http://www.google.com");
            p.setTxRef("MX-678DH");
            p.setEmail("sogunledolapo@gmail.com");
           
        
           JSONObject response=p.handleTimeoutCharge();
        
       if(response.get("status").equals("success")){
            assertEquals(response.get("status"),"success");
              System.out.println("Polling successful");
           System.out.println(response);
           }else{
           
            assertEquals(response.get("status"),"error");
            System.out.println("No need for polling, No timeouts!!!.Follow the instruction ");
           System.out.println(response);
           }
       
       
       p.setTransaction_reference("ACHG-1520028650995");
        p.setOtp("12345"); 
        
        JSONObject resp=p.handleTimeoutValidateCharge();
         if(resp.get("status").equals("success")){
            assertEquals(resp.get("status"),"success");
             System.out.println("Polling successful");
            System.out.println(resp);
           }else{
           
            assertEquals(resp.get("status"),"error");
            System.out.println("No need for polling, No timeouts!!!.Follow the instruction ");
            System.out.println(resp);
           }
       
       
       }
        @Test
       public void testPolling()throws JSONException{ 
             Polling p=new Polling();

          p.setAccountnumber("0690000031");
            p.setAccountbank("ACCSS");
            p.setAmount("1000");
            p.setCountry("NG");
            p.setCurrency("NGN");
            p.setLastname("Theresa");
            p.setIP("1.3.4.4");
            p.setPayment_type("account");
            p.setTxRef("MX-678DH");
            p.setEmail("sogunledolapo@gmail.com");
          
        
        JSONObject response=p.handleTimeoutCharge();
        
       if(response.get("status").equals("success")){
            assertEquals(response.get("status"),"success");
          System.out.println("Polling successful");
            System.out.println(response);
           }else{
           
            assertEquals(response.get("status"),"error");
            System.out.println("No need for polling, No timeouts!!!.Follow the instruction ");
            System.out.println(response);
           }
       
       
        p.setTransaction_reference("ACHG-1520028650995");
        p.setOtp("12345"); 
        
        JSONObject resp=p.handleTimeoutValidateCharge();
         if(resp.get("status").equals("success")){
            assertEquals(resp.get("status"),"success");
              System.out.println("Polling successful");
            System.out.println(resp);
           }else{
           
            assertEquals(resp.get("status"),"error");
            System.out.println("No need for polling, No timeouts!!!.Follow the instruction ");
            System.out.println(resp);
           }
       
       
       }
}
