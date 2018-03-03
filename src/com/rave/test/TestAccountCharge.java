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
          ch.setAccountnumber("0690000031")
            .setAccountbank("044")
            .setAmount("1000")
            .setCountry("NG")
            .setCurrency("NGN")
            .setLastname("Theresa")
            .setIP("1.3.4.4")
            .setPayment_type("account")
            .setTxRef("MX-678DH")
            .setEmail("sogunledolapo@gmail.com");
          
          
          
           JSONObject result=ch.chargeAccount();
           

        //validate
        ch.setTransaction_reference("ACHG-1520028650995");
        ch.setOtp("12345"); 
        //for polling
        JSONObject polling=ch.validateAccountCharge(true);
        System.out.println(polling);
        //without polling
        JSONObject val=ch.validateAccountCharge();
        System.out.println(val);
    }
}
