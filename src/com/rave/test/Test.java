/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.AccountCharge;
import com.rave.AlternativePayment;
import com.rave.Bank;
import com.rave.CardCharge;
import com.rave.Environment;
import com.rave.ExchangeRates;
import com.rave.Fees;
import com.rave.IntegrityChecksum;
import com.rave.PreAuthorization;
import com.rave.RaveConstant;
import com.rave.Refund;
import com.rave.Transaction;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */

public class Test {
    public static void main(String [] args) throws JSONException{
        
        RaveConstant.PUBLIC_KEY="FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY="FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT=Environment.STAGING;
        
        chargeAccountTest();
       // chargeCardTest();
    //    getBanks();
      //  exchangeRatesTest();
      //  feesTest();
      //  checksumTest();
        //preAuthTest();
        //refundTest();
        //verifyRequeryXquery();
        //alternativePaymentTest();
        
        
       
    }
    public static void chargeAccountTest()throws JSONException{
         AccountCharge ch=new AccountCharge();
          ch.setAccountnumber("0690000031")
            .setAccountbank("044")
            .setAmount("1000")
            .setCountry("NG")
            .setCurrency("NGN")
            .setLastname("Theresa")
            .setTxRef("MX-678DH")
            .setEmail("sogunledolapo@gmail.com");
               
          
       // JSONObject result=ch.chargeAccount();
       // System.out.println(result);
          
          
           //validate
      ch.setTransaction_reference("ACHG-1524613307896");
       ch.setOtp("12345"); 
        //for polling  JSONObject polling=ch.validateAccountCharge(true);
    
    
      JSONObject val=ch.validateAccountCharge();
       
      System.out.println(val);
  
          
    }
     public static void chargeCardTest()throws JSONException{
        CardCharge ch=new CardCharge();
        ch.setCardno("4187427415564246")
          .setCvv("828")
          .setCurrency("NGN")
          .setCountry("NG")
          .setAmount("9000")
          .setExpiryyear("19")
          .setExpirymonth("09")
          .setEmail("sogunledolapo@gmail.com")
          .setIP("103.238.105.185")
          .setTxRef("MXX-ASC-4578")
          .setDevice_fingerprint("69e6b7f0sb72037aa8428b70fbe03986c");
     
         //for master card and verve
          ch.setPin("3310")
            .setSuggested_auth("PIN");
          
          JSONObject result=ch.chargeMasterAndVerveCard();
          System.out.println(result);
          
         
       //     JSONObject poll=ch.chargeMasterAndVerveCard(true);
   
       //for visa and intl cards
           //ch.setRedirect_url("http://www.google.com");
        //   JSONObject chargevisa=ch.chargeVisaAndIntl();
          // System.out.println(chargevisa);
            //if timeout, poll JSONObject pollvisa=ch.chargeVisaAndIntl(true);
            //validate
        //   ch.setOtp("12345");
          // ch.setTransactionreference("FLW-MOCK-2638e6fe8a7713e332f8991f25c415af");
       
          //JSONObject validateCharge=ch.validateCardCharge();
          //System.out.println(validateCharge);
            //if timeout  JSONObject validatepoll=ch.validateCardCharge(true);
        
    }
     public static void getBanks() throws JSONException{
     
       Bank b= new Bank();
       System.out.println(b.getAllBanks());
     
     }
     private static void exchangeRatesTest(){
     
      ExchangeRates e=new ExchangeRates();
        e.setAmount("500")
         .setDestination_currency("USD")
         .setOrigin_currency("NGN");
        System.out.println( e.forex());

    
     }
    public static void feesTest(){
    Fees fee=new Fees();
           fee.setAmount("500")
              .setCard6("829222")
              .setCurrency("NGN");
        
        System.out.println(fee.getFees());
        System.out.println(fee.getFeesForCard6());
    }
    public static void checksumTest() {
    IntegrityChecksum ch=new IntegrityChecksum();
        
           ch.setAmount("20")
            .setPayment_method("both")
            .setCustom_description("Pay Internet")
            .setCustom_logo("http://localhost/payporte-3/skin/frontend/ultimo/shoppy/custom/images/logo.svg")
            .setCountry("NG")
            .setCurrency("NGN")
            .setCustomer_email( "user@example.com")
            .setCustomer_firstname("Temi")
            .setCustomer_lastname("Adelewa")
            .setCustomer_phone("234099940409")
            .setTxref("MG-CKSKKHH");
       
          String hash= ch.integrityChecksum();
       
          System.out.println(hash);
       
    }
    
    public static void preAuthTest()throws JSONException{
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
        
       
            ch.setFlwref("FLW-MOCK-d310263f5f73e51d01e6dab32c893679")
              .setAction("refund");
            JSONObject capture=  ch.capture();
            JSONObject refund= ch.refundOrVoid();
            
            System.out.println(capture);
            System.out.println(refund);
            System.out.println(response);
    }
     public static void refundTest(){
        Refund rf=new Refund();
        rf.setRef("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
        System.out.println(rf.refund());
     }
     
     public static void verifyRequeryXquery(){
       Transaction t=new Transaction();
         t.setFlwref("FLW-MOCK-d310263f5f73e51d01e6dab32c893679")
          .setTxRef("");
         t.verifyTransactionXrequery();
        System.out.println(t.verifyTransactionRequery());
     
     }
     
     public static void alternativePaymentTest() throws JSONException{
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
          System.out.println(chargeussd);
              
    
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
          System.out.println(chargegh);
        
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
    System.out.println(chargempesa);
   
   
       //complete Transaction
          Transaction t=new Transaction();
           t.setFlwref("FLW-MOCK-XXXXXXXXXXXXXXXXXXXXXXX");
        //  System.out.println( t.verifyTransactionRequery());
   
     }
}
