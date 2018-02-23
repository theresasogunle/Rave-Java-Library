/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

/**
 *
 * @author Theresa
 */
public class Endpoints {
    
 
      public static final String CARD_CHARGE_ENDPOINT = "http://flw-pms-dev.eu-west-1.elasticbeanstalk.com/flwv3-pug/getpaidx/api/charge";
      public static final String CARD_VALIDATE_ENDPOINT = "http://flw-pms-dev.eu-west-1.elasticbeanstalk.com/flwv3-pug/getpaidx/api/validatecharge";
      
      public static final String BANK_ENDPOINT="http://flw-pms-dev.eu-west-1.elasticbeanstalk.com/flwv3-pug/getpaidx/api/flwpbf-banks.js?json=1";
      
      public static final String TIMEOUT_ENDPOINT="http://flw-pms-dev.eu-west-1.elasticbeanstalk.com/flwv3-pug/getpaidx/api/charge?use_polling=1";
      public static final String POLL_ENDPOINT="https://rave-api-v2.herokuapp.com/flwv3-pug/getpaidx/api/requests/RCORE_CHREQ_3FC28781846AD8E1C598";
      
      public static final String FEES_ENDPOINT="http://flw-pms-dev.eu-west-1.elasticbeanstalk.com/flwv3-pug/getpaidx/api/fee";
      
      public static final String REFUND_ENDPOINT="http://flw-pms-dev.eu-west-1.elasticbeanstalk.com/gpx/merchant/transactions/refund";
      
      public static final String FOREX_ENDPOINT="http://flw-pms-dev.eu-west-1.elasticbeanstalk.com/flwv3-pug/getpaidx/api/forex";
      
      public static final String VERIFY_TRANSACTION_ENDPOINT="http://flw-pms-dev.eu-west-1.elasticbeanstalk.com/flwv3-pug/getpaidx/api/verify";
      public static final String VERIFY_XQUERY_ENDPOINT="http://flw-pms-dev.eu-west-1.elasticbeanstalk.com/flwv3-pug/getpaidx/api/xrequery";
      public static final String CAPTURE_ENDPOINT="http://flw-pms-dev.eu-west-1.elasticbeanstalk.com/flwv3-pug/getpaidx/api/capture";
      public static final String REFUNDVOID_ENDPOINT="http://flw-pms-dev.eu-west-1.elasticbeanstalk.com/flwv3-pug/getpaidx/api/refundorvoid";
      
}
