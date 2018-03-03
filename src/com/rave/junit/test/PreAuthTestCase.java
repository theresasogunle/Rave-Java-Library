/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.junit.test;


import com.rave.PreAuthorization;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class PreAuthTestCase {
    @Test
    public void test() throws JSONException{
      
       
       
       PreAuthorization ch=new PreAuthorization();
       
       //card charge
      
        ch.setCardno("5438898014560229")
          .setCharge_type("preauth")
          .setCvv("812")
          .setExpirymonth("08")
          .setExpiryyear("20")
          .setCurrency("NGN")
          .setCountry("NG")
          .setAmount("100")
          .setEmail("user@example.com")
          .setPhonenumber("08056552980")
          .setFirstname("user")
          .setLastname("example")
          .setIP("40.198.14")
          .setTxRef("MXX-ASC-4578")
          .setRedirect_url("https://rave-web.herokuapp.com/receivepayment")
          .setDevice_fingerprint("69e6b7f0b72037aa8428b70fbe03986c");
       
       
        JSONObject response=ch.preAuthorizeCard();
        if(response.get("status").equals("success")){
        //    assertEquals(response.get("status"),"success");
         //   System.out.println(response);
           }else{
           
          //  assertEquals(response.get("status"),"error");
            //System.out.println("Authorization not successful");
          //  System.out.println(response);
           }
       
            ch.setFlwref("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
            ch.setAction("refund");
            JSONObject capture=  ch.capture();
            JSONObject refund= ch.refundOrVoid();
       
           if(capture.get("status").equals("success")){
           // assertEquals(capture.get("status"),"success");
         //   System.out.println(capture);
           }else{
           
          //  assertEquals(capture.get("status"),"error");
          //  System.out.println("Capture not successful");
           // System.out.println(capture);
           }
           if(refund.get("status").equals("success")){
           // assertEquals(refund.get("status"),"success");
           // System.out.println(refund);
           }else{
           
          //  assertEquals(refund.get("status"),"error");
          //  System.out.println("Refund not successful");
          //  System.out.println(refund);
           }
      
    }
}
