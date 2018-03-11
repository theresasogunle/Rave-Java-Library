/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.junit.test;

import com.rave.AlternativePayment;
import com.rave.Transaction;
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
        /*
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

*/


        
        
        
        
           // JSONObject chargeussd=ch.chargeNigerianUssd();
            //System.out.println(chargeussd);
         //assertEquals(chargeussd.get("status"),"success");
        //complete transaction
            //  Transaction t=new Transaction();
            // t.setFlwref("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
          // System.out.println( t.verifyTransactionRequery());
    
    //for ghana mobile money
       /*
  
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
      
       
  
    //  String encrypted_message= encryption.encryptParameters(api);
          JSONObject chargegh=ch.chargeGhanaMobileMoney();
          System.out.println(chargegh);
        */
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
  //   assertEquals(chargempesa.get("status"),"success");
      //  System.out.println(chargempesa);
       
   
       
 //   System.out.println(charge);
          
    }
    
}
