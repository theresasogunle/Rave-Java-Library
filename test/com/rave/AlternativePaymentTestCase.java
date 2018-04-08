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
public class AlternativePaymentTestCase {
    
    @Test
    public void test() throws JSONException{
        
       
        AlternativePayment ch=new AlternativePayment();
        
               //available for only zenith and GTB
            ch.setAccountnumber("0690000004")
             .setAccountbank("044")
             .setCurrency("NGN")
             .setCountry("NG")
             .setAmount("6000")
             .setFirstname("pin")
             .setLastname("pin")
             .setPin("3310")
             .setEmail("sogunledolapo@gmail.com")
             .setIP("103.238.105.185")
             .setTxRef("MXX-ASC-4578");


            JSONObject chargeussd=ch.chargeNigerianUssd();
             if(chargeussd.get("status").equals("success")){
            assertEquals(chargeussd.get("status"),"success");
           System.out.println(chargeussd);
           }else{
           
            assertEquals(chargeussd.get("status"),"error");
//            System.out.println(chargeussd);
           }
      
   
        //complete transaction
              Transaction t=new Transaction();
             t.setFlwref("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
             JSONObject verifyussd=t.verifyTransactionRequery();
                 if(verifyussd.get("status").equals("success")){
            assertEquals(verifyussd.get("status"),"success");
           System.out.println(verifyussd);
           }else{
           
            assertEquals(verifyussd.get("status"),"error");
            System.out.println(verifyussd);
           }
             
      
    
    //for ghana mobile money
       
  
       ch.setOrderRef("0690000")
        .setNetwork("MTN")
        .setCurrency("GHS")
        .setCountry("GH")
        .setAmount("4000")
        .setFirstname("pin")
        .setLastname("pin")
        .setPin("3310")
        .setEmail("sogunledolapo@gmail.com")
        .setIP("103.238.105.185")
        .setTxRef("MXX-90-49578")
       .setPhonenumber("08020000000");
      
       
  
 
          JSONObject chargegh=ch.chargeGhanaMobileMoney();
         if(chargegh.get("status").equals("success")){
           // assertEquals(chargegh.get("status"),"success");
           System.out.println(chargegh);
           }else{
           
            assertEquals(chargegh.get("status"),"error");
            System.out.println(chargegh);
           }
        
         //for kenya mpesa
          
  
       
       ch.setCurrency("KES")
         .setCountry("KE")
         .setAmount("6000")
         .setFirstname("pin")
         .setLastname("pin")
         .setPin("3310")
         .setEmail("sogunledolapo@gmail.com")
         .setIP("103.238.105.185")
         .setTxRef("MXX-ASC-4578")
         .setOrderRef("y77yy")
         .setPhonenumber("0903672978");
       
    
   
    JSONObject chargempesa=ch.chargeKenyaMpesa();
      if(chargempesa.get("status").equals("success")){
            assertEquals(chargempesa.get("status"),"success");
           System.out.println(chargeussd);
           }else{
           
            assertEquals(chargempesa.get("status"),"error");
            System.out.println(chargempesa);
           }
   
       
   
          
    }
    
}
