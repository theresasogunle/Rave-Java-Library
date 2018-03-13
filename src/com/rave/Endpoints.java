/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

/**
 *
 * @author Theresa
 */
public class Endpoints {
       Keys key= new Keys();
      String staging_url="http://flw-pms-dev.eu-west-1.elasticbeanstalk.com/";
      String live_url="https://api.ravepay.co/";
      String  url;
      public  String BANK_ENDPOINT;
      public static String CARD_CHARGE_ENDPOINT;
      public static String CARD_VALIDATE_ENDPOINT;
      public static String TIMEOUT_ENDPOINT;
      public static String POLL_ENDPOINT;
      public static String FEES_ENDPOINT;
      public static String REFUND_ENDPOINT;
      public static String FOREX_ENDPOINT;
      public static String VERIFY_TRANSACTION_ENDPOINT;
      public static String VERIFY_XREQUERY_ENDPOINT;
      public static String CAPTURE_ENDPOINT;
      public static String REFUNDVOID_ENDPOINT;
      public static String CHARGE_TIMEOUT_ENDPOINT;
      public static String VALIDATE_CHARGE_TIMEOUT_ENDPOINT;
      public static String IP_ENDPOINT;
      
     
      void init(){
      
          if(key.getEnvironment().equalsIgnoreCase("live")){
           
            url=live_url;
          
          }
          else {
          url=staging_url;
          }
         
       BANK_ENDPOINT= url+"/flwv3-pug/getpaidx/api/flwpbf-banks.js?json=1";
       CARD_CHARGE_ENDPOINT =url+"/flwv3-pug/getpaidx/api/charge";
       CARD_VALIDATE_ENDPOINT = url+"flwv3-pug/getpaidx/api/validatecharge";
       TIMEOUT_ENDPOINT=url+"flwv3-pug/getpaidx/api/charge?use_polling=1";
       POLL_ENDPOINT=url+"flwv3-pug/getpaidx/api/requests/RCORE_CHREQ_3FC28781846AD8E1C598";
        FEES_ENDPOINT=url+"flwv3-pug/getpaidx/api/fee";
       REFUND_ENDPOINT=url+"gpx/merchant/transactions/refund";
       FOREX_ENDPOINT=url+"/flwv3-pug/getpaidx/api/forex";
       VERIFY_TRANSACTION_ENDPOINT=url+"flwv3-pug/getpaidx/api/verify";
       VERIFY_XREQUERY_ENDPOINT=url+"flwv3-pug/getpaidx/api/xrequery";
        CAPTURE_ENDPOINT=url+"flwv3-pug/getpaidx/api/capture";
        REFUNDVOID_ENDPOINT=url+"flwv3-pug/getpaidx/api/refundorvoid";
        CHARGE_TIMEOUT_ENDPOINT=url+"flwv3-pug/getpaidx/api/charge?use_polling=1";
        VALIDATE_CHARGE_TIMEOUT_ENDPOINT=url+"flwv3-pug/getpaidx/api/validatecharge?use_polling=1";
        IP_ENDPOINT="http://bot.whatismyipaddress.com";
      }
      
     public String getBankEndPoint(){
         init();
         return BANK_ENDPOINT;
     
     }
      public String getIPEndPoint(){
         init();
         return IP_ENDPOINT;
     
     }
     public String getChargeEndPoint(){
         init();
         return CARD_CHARGE_ENDPOINT;
     
     }
     public String getValidateChargeEndPoint(){
         init();
         return CARD_VALIDATE_ENDPOINT;
     
     }
     public String getFeesEndPoint(){
         init();
         return FEES_ENDPOINT;
     
     }
     public String getRefundEndPoint(){
         init();
         return REFUND_ENDPOINT;
     
     }
     public String getForexEndPoint(){
         init();
         return FOREX_ENDPOINT;
     
     }
     public String getVerifyEndPoint(){
         init();
         return VERIFY_TRANSACTION_ENDPOINT;
     
     }
     public String getVerifyXrequeryEndPoint(){
         init();
         return VERIFY_XREQUERY_ENDPOINT;
     
     }
     public String getCaptureEndPoint(){
         init();
         return CAPTURE_ENDPOINT;
     
     }
     public String getRefundOrVoidEndPoint(){
         init();
         return  REFUNDVOID_ENDPOINT;
     
     }
      public String getChargeTimeoutEndpoint(){
         init();
         return CHARGE_TIMEOUT_ENDPOINT;
     
     }
        public String getValidateChargeTimeoutEndpoint(){
         init();
         return VALIDATE_CHARGE_TIMEOUT_ENDPOINT;
     
     }
      
       
    
      
      
      
}
