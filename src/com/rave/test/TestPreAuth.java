/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.PreAuthorization;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class TestPreAuth {
    public static void main(String[] args) throws JSONException{
     
       PreAuthorization ch=new PreAuthorization();
       
       //card charge
      
       
        ch.setCardno("5438898014560229");
        ch.setCharge_type("preauth");
        ch.setCvv("812");
        ch.setExpirymonth("08");
        ch.setExpiryyear("20");
        ch.setCurrency("NGN");
        ch.setCountry("NG");
        ch.setAmount("100");
        ch.setEmail("user@example.com");
        ch.setPhonenumber("08056552980");
        ch.setFirstname("user");
        ch.setLastname("example");
        ch.setIP("40.198.14");
        ch.setTxRef("MXX-ASC-4578");
        ch.setRedirect_url("https://rave-web.herokuapp.com/receivepayment");
        ch.setDevice_fingerprint("69e6b7f0b72037aa8428b70fbe03986c"); 
       
       
             JSONObject response=ch.preAuthorizeCard();
        
       
            ch.setFlwref("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
            ch.setAction("refund");
            JSONObject capture=  ch.capture();
            JSONObject refund= ch.refundOrVoid();
            
            //System.out.println(capture);
            //System.out.println(refund);
            //System.out.println(response);
       
           
           
    } 
}
