/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import java.util.HashMap;

/**
 *
 * @author Theresa
 */
public class IntegrityChecksum {
      
        Keys key=new Keys();
    private String amount, payment_method,custom_description,custom_logo,country,currency,
           customer_email, customer_lastname,customer_firstname,customer_phone,txref;
    
    
    public String integrityChecksum(){
         HashMap payload=new HashMap();
         
        payload.put("PBFPubKey" ,key.getPublicKey());
        payload.put("amount" ,this.getAmount());
        payload.put("payment_method", this.getPayment_method());
        payload.put("custom_description",this.getCustom_description());
        payload.put("custom_logo",this.getCustom_logo());
        payload.put("country", this.getCountry());
        payload.put("currency", this.getCurrency());
        payload.put ("customer_email", this.getCustomer_email());
        payload.put(  "customer_firstname", this.getCustomer_firstname());
        payload.put("customer_lastname", this.getCustomer_lastname());
        payload.put("customer_phone", this.getCustomer_phone());
        payload.put( "txref",this.getTxref());

        payload.put("PBFPubKey", key.getPublicKey());
    
     
       Object[] keys=payload.keySet().toArray();
       Arrays.sort(keys);
       String hashedPayload = "";
       String hashString="";

            for(int i=0;i<keys.length;i++){
                 Object key= keys[i];
                 hashedPayload+=payload.get(key);
            }
                hashString  = hashedPayload + key.getSecretKey();
                String hash_string="";

                try{
                        MessageDigest digest = MessageDigest.getInstance("SHA-256");
                        byte[]  hash = digest.digest(hashString.getBytes(StandardCharsets.UTF_8));
                        hash_string=Base64.getEncoder().encodeToString(hash);
                      //  System.out.println(hash_string);
                    }catch(Exception ex){}

                return hash_string;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the payment_method
     */
    public String getPayment_method() {
        return payment_method;
    }

    /**
     * @param payment_method the payment_method to set
     */
    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    /**
     * @return the custom_description
     */
    public String getCustom_description() {
        return custom_description;
    }

    /**
     * @param custom_description the custom_description to set
     */
    public void setCustom_description(String custom_description) {
        this.custom_description = custom_description;
    }

    /**
     * @return the custom_logo
     */
    public String getCustom_logo() {
        return custom_logo;
    }

    /**
     * @param custom_logo the custom_logo to set
     */
    public void setCustom_logo(String custom_logo) {
        this.custom_logo = custom_logo;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the customer_email
     */
    public String getCustomer_email() {
        return customer_email;
    }

    /**
     * @param customer_email the customer_email to set
     */
    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    /**
     * @return the customer_lastname
     */
    public String getCustomer_lastname() {
        return customer_lastname;
    }

    /**
     * @param customer_lastname the customer_lastname to set
     */
    public void setCustomer_lastname(String customer_lastname) {
        this.customer_lastname = customer_lastname;
    }

    /**
     * @return the customer_firstname
     */
    public String getCustomer_firstname() {
        return customer_firstname;
    }

    /**
     * @param customer_firstname the customer_firstname to set
     */
    public void setCustomer_firstname(String customer_firstname) {
        this.customer_firstname = customer_firstname;
    }

    /**
     * @return the customer_phone
     */
    public String getCustomer_phone() {
        return customer_phone;
    }

    /**
     * @param customer_phone the customer_phone to set
     */
    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    /**
     * @return the txref
     */
    public String getTxref() {
        return txref;
    }

    /**
     * @param txref the txref to set
     */
    public void setTxref(String txref) {
        this.txref = txref;
    }
    
  
}
