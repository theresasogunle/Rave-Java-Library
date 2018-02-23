/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.Transaction;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class TestTransactionVerification {
    public static void main(String [] args){
   
       Transaction t=new Transaction();
      JSONObject tt= t.verifyTransactionXquery("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
        System.out.println(tt);
       
    
    }
}
