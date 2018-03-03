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
           ch.setAccountnumber("0690000004");
           ch.setAccountbank("044");
           ch.setCurrency("NGN");
           ch.setCountry("NG");
           ch.setAmount("6000");
           ch.setFirstname("pin");
           ch.setLastname("pin");
           ch.setPin("3310");
           ch.setEmail("sogunledolapo@gmail.com");
           ch.setIP("103.238.105.185");
          ch.setTxRef("MXX-ASC-4578");
*/


        
        
        
        
           // JSONObject chargeussd=ch.chargeNigerianUssd();
            //System.out.println(chargeussd);
        //complete transaction
            //  Transaction t=new Transaction();
            // t.setFlwref("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
          // System.out.println( t.verifyTransactionRequery());
    
    //for ghana mobile money
       /*
  
      ch.setOrderRef("0690000");
      ch.setNetwork("MTN");
      ch.setCurrency("GHS");
      ch.setCountry("GH");
      ch.setAmount("4000");
      ch.setFirstname("pin");
      ch.setLastname("pin");
      ch.setPin("3310");
      ch.setEmail("sogunledolapo@gmail.com");
      ch.setIP("103.238.105.185");
      ch.setTxRef("MXX-90-49578");
      ch.setPhonenumber("0908467482");
      
       
  
    //  String encrypted_message= encryption.encryptParameters(api);
          JSONObject chargegh=ch.chargeGhanaMobileMoney();
          System.out.println(chargegh);
        */
         //for kenya mpesa
          
  
       
       ch.setCurrency("KES");
       ch.setCountry("KE");
       ch.setAmount("6000");
       ch.setFirstname("pin");
       ch.setLastname("pin");
       ch.setPin("3310");
       ch.setEmail("sogunledolapo@gmail.com");
       ch.setIP("103.238.105.185");
       ch.setTxRef("MXX-ASC-4578");
       ch.setOrderRef("y77yy");
       ch.setPhonenumber("0903672978");
       
    
   
    JSONObject chargempesa=ch.chargeKenyaMpesa();
    
      //  System.out.println(chargempesa);
       
   
       
 //   System.out.println(charge);
          
    }
    
}
