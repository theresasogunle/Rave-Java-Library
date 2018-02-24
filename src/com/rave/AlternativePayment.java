/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;


import org.json.JSONObject;


/**
 *
 * @author Theresa
 */
public class AlternativePayment {
    
    ApiConnection apiConnection;

    /**
    *
    * @param encrypted_message
    * @return JSONObject
    */
    
    // charge customers using nigerian USSD for GTB and Zenith Bank,Ghana mobile money and Kenya Mpesa
    public JSONObject alternativePaymentCharge(String encrypted_message){
        //getting charge endpoint
        Charge cha= new Charge();
        
        return  cha.charge(encrypted_message); 
    }

    /**
    *
    * @param txref
    * @param flwref
    * @return JSONObject
    */ 
    //to requery transaction for ghana mobile money,kenya mpesa and nigerian ussd using xquery
    public JSONObject completeTransactionWithXquery(String txref="", String flwref=""){
     
        Transaction t= new Transaction();
        
        return t.verifyTransactionXquery(txref, flwref);
    
    }

    /**
    *
    * @param flw_ref
    * @return JSONObject
    */
    public JSONObject completeTransactionRequery(String flw_ref){   
        Transaction t= new Transaction();
        
        return t.verifyTransactionRequery(flw_ref);
    }
}
