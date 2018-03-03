/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;


import static com.rave.Encryption.encryptData;
import org.json.JSONException;
import org.json.JSONObject;



/**
 *
 * @author Theresa
 */
public class AlternativePayment {
    
    ApiConnection apiConnection;

   Encryption e=new Encryption();
   Keys key=new Keys();
   
   private String accountnumber,accountbank,currency,country,amount,firstname,lastname,
           pin,email,IP,txRef,phonenumber,orderRef,network,flwRef;


    /**
    *
    * @param client
    * @return JSONObject
    */
    
    // charge customers using nigerian USSD for GTB and Zenith Bank,Ghana mobile money and Kenya Mpesa
 
     public JSONObject chargeNigerianUssd () throws JSONException{
        //getting charge endpoint
         JSONObject json=new JSONObject();
          json.put("accountnumber", this.getAccountnumber());
           json.put("accountbank", this.getAccountbank());
           json.put("currency", this.getCurrency());
           json.put("country", this.getCountry());
           json.put("amount", this.getAmount());
           json.put("firstname", this.getFirstname());
           json.put("lastname", this.getLastname());
           json.put("pin", this.getPin());
           json.put("email", this.getEmail());
           json.put("IP", this.getIP());
           json.put("txRef", this.getTxRef());
           json.put("payment_type", "ussd");
           
           
           String message= json.toString();
        
        String encrypt_secret_key=e.getKey(key.getSecretKey());
        String client= encryptData(message,encrypt_secret_key);

        Charge ch=new Charge();
        
        return ch.charge(client);

    }
     public JSONObject chargeGhanaMobileMoney () throws JSONException{
        //getting charge endpoint
         JSONObject json=new JSONObject();
       json.put("orderRef",this.getOrderRef());
       json.put("network", this.getNetwork());
       json.put("currency", this.getCurrency());
       json.put("country", this.getCountry());
       json.put("amount", this.getAmount());
       json.put("firstname", this.getFirstname());
       json.put("lastname", this.getLastname());
       json.put("pin", this.getPin());
       json.put("email", this.getEmail());
       json.put("IP", this.getIP());
       json.put("txRef", this.getTxRef());
       json.put("payment_type", "mobilemoneygh");
        json.put("is_mobile_money_gh", "1");
        json.put("phonenumber",this.getPhonenumber());
           
      String message= json.toString();
        
        String encrypt_secret_key=e.getKey(key.getSecretKey());
        String client= encryptData(message,encrypt_secret_key);

        Charge ch=new Charge();
        
        return ch.charge(client);

    }
      public JSONObject chargeKenyaMpesa () throws JSONException{
        //getting charge endpoint
          JSONObject json=new JSONObject();
       json.put("currency", this.getCurrency());
       json.put("country", this.getCountry());
       json.put("amount", this.getAmount());
       json.put("firstname", this.getFirstname());
       json.put("lastname", this.getLastname());
       json.put("pin", this.getPin());
       json.put("email", this.getEmail());
       json.put("IP", this.getIP());
       json.put("txRef", this.getTxRef());
       json.put("orderRef", this.getOrderRef());
       json.put("phonenumber", this.getPhonenumber());
       json.put("payment_type", "mpesa");
       json.put("is_mpesa", "1");
         String message= json.toString();
        
        String encrypt_secret_key=e.getKey(key.getSecretKey());
        String client= encryptData(message,encrypt_secret_key);

        Charge ch=new Charge();
        
        return ch.charge(client); 

    }

    /**
    *
    * @param txref
    * @param flwref
    * @return JSONObject
    */ 
    //to requery transaction for ghana mobile money,kenya mpesa and nigerian ussd using xquery

 

    /**
     * @return the accountnumber
     */
    public String getAccountnumber() {
        return accountnumber;
    }

    /**
     * @param accountnumber the accountnumber to set
     */
    public AlternativePayment setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
        return this;
    }

    /**
     * @return the accountbank
     */
    public String getAccountbank() {
        return accountbank;
    }

    /**
     * @param accountbank the accountbank to set
     */
    public AlternativePayment setAccountbank(String accountbank) {
        this.accountbank = accountbank;
         return this;
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
    public AlternativePayment setCurrency(String currency) {
        this.currency = currency;
         return this;
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
    public AlternativePayment setCountry(String country) {
        this.country = country;
         return this;
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
    public AlternativePayment setAmount(String amount) {
        this.amount = amount;
         return this;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public AlternativePayment setFirstname(String firstname) {
        this.firstname = firstname;
         return this;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public AlternativePayment setLastname(String lastname) {
         this.lastname = lastname;
         return this;
    }

    /**
     * @return the pin
     */
    public String getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public AlternativePayment setPin(String pin) {
        this.pin = pin;
         return this;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public AlternativePayment setEmail(String email) {
        this.email = email;
         return this;
    }

    /**
     * @return the IP
     */
    public String getIP() {
        return IP;
    }

    /**
     * @param IP the IP to set
     */
    public AlternativePayment setIP(String IP) {
        this.IP = IP;
         return this;
    }

    /**
     * @return the txRef
     */
    public String getTxRef() {
        return txRef;
    }

    /**
     * @param txRef the txRef to set
     */
    public AlternativePayment setTxRef(String txRef) {
        this.txRef = txRef;
         return this;
    }

    /**
     * @return the phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber the phonenumber to set
     */
    public AlternativePayment setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
         return this;
    }

    /**
     * @return the orderRef
     */
    public String getOrderRef() {
        return orderRef;
    }

    /**
     * @param orderRef the orderRef to set
     */
    public AlternativePayment setOrderRef(String orderRef) {
        this.orderRef = orderRef;
         return this;
    }

    /**
     * @return the network
     */
    public String getNetwork() {
        return network;
    }

    /**
     * @param network the network to set
     */
    public AlternativePayment setNetwork(String network) {
        this.network = network;
         return this;
    }

    /**
     * @return the flwRef
     */
    public String getFlwRef() {
        return flwRef;
    }

    /**
     * @param flwRef the flwRef to set
     */
    public AlternativePayment setFlwRef(String flwRef) {
        this.flwRef = flwRef;
         return this;
    }
}
