/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;


import com.rave.AccountCharge;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class TestAccountCharge {
    public static void main(String [] args) throws JSONException{
      
        
        AccountCharge ch=new AccountCharge();
        
            ch.setAccountnumber("0690000031");
            ch.setAccountbank("044");
            ch.setAmount("1000");
            ch.setCountry("NG");
            ch.setCurrency("NGN");
            ch.setLastname("Theresa");
            ch.setIP("1.3.4.4");
            ch.setPayment_type("account");
            ch.setTxRef("MX-678DH");
            ch.setEmail("sogunledolapo@gmail.com");
          
          
           JSONObject result=ch.chargeAccount();
       

        //validate
        ch.setTransaction_reference("ACHG-1520028650995");
        ch.setOtp("12345"); 
        JSONObject val=ch.validateAccountCharge();

        System.out.println(val);
    }
}
