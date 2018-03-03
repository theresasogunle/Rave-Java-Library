/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.junit.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Theresa
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
   AccountChargeTest.class,
  CardChargeTestCase.class,
  BankTestCase.class,
  ExchangeRatesTestCase.class ,
  FeesTestCase.class ,
  IntegrityChecksumTestCase.class,
  RefundTestCase.class,
  PreAuthTestCase.class,
  TransactionVerificationTestCase.class,
  AlternativePaymentTestCase.class,
 
        
})
public class JUnitTestSuite {
    
}
