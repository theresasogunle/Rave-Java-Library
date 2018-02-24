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
<<<<<<< HEAD
     public   String txref,flwref;
=======
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4

    /**
    *
    * @param encrypted_message
    * @return JSONObject
    */
    
    // charge customers using nigerian USSD for GTB and Zenith Bank,Ghana mobile money and Kenya Mpesa
    public JSONObject alternativePaymentCharge(String client){
        //getting charge endpoint
        Charge cha= new Charge();
        
<<<<<<< HEAD
        return  cha.charge(client); 
=======
        return  cha.charge(encrypted_message); 
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
    }

    /**
    *
    * @param txref
    * @param flwref
    * @return JSONObject
    */ 
    //to requery transaction for ghana mobile money,kenya mpesa and nigerian ussd using xquery
<<<<<<< HEAD
    public JSONObject completeTransactionWithXrequery(){
     
        Transaction t= new Transaction();
        
        return t.verifyTransactionXrequery();
=======
    public JSONObject completeTransactionWithXquery(String txref="", String flwref=""){
     
        Transaction t= new Transaction();
        
        return t.verifyTransactionXquery(txref, flwref);
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
    
    }

    /**
    *
    * @param flw_ref
    * @return JSONObject
    */
<<<<<<< HEAD
    public JSONObject completeTransactionRequery(){   
=======
    public JSONObject completeTransactionRequery(String flw_ref){   
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
        Transaction t= new Transaction();
        
        return t.verifyTransactionRequery();
    }
}
