/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import com.mashape.unirest.http.JsonNode;
import static com.rave.Encryption.encryptData;

import org.json.JSONException;

import org.json.JSONObject;




/**
 *
 * @author Theresa
 */
public class AccountCharge {
    
    private ApiConnection apiConnection;
    private Keys key = new Keys();
    private Endpoints end= new Endpoints();
    Encryption e=new Encryption();
    
    private String accountnumber,accountbank,currency,country,amount,email,phonenumber,firstname,lastname,IP,
            txRef,payment_type,passcode,device_fingerprint;
    



  
      
    private String transaction_reference;//to be called
    private String otp;//to be called
 
   
    
    public JsonNode getAllBanks(){   
 
        Bank b=new Bank();
    
        return b.getAllBanks();
    }

    /**
    *

    * @return json
    */   
    public JSONObject chargeAccount() throws JSONException{
        JSONObject json=new JSONObject();
        
        json.put("PBFPubKey",key.getPublicKey());
        json.put("accountnumber",this.getAccountnumber());//expected result'
        json.put("accountbank",this.getAccountbank());
        json.put("currency", this.getCurrency());
        json.put("country", this.getCountry());
        json.put("amount", this.getAmount());
        json.put("firstname", this.getFirstname());
        json.put("lastname", this.getLastname());
        json.put("passcode", this.getPasscode());
        json.put("email", this.getEmail());
        json.put("IP", this.getIP());
        json.put("payment_type", this.getPayment_type());
        json.put("txRef", this.getTxRef());
        json.put("device_fingerprint", this.getDevice_fingerprint());

        String message= json.toString();
        
        String encrypt_secret_key=e.getKey(key.getSecretKey());
        String client= encryptData(message,encrypt_secret_key);

        Charge ch=new Charge();
        
        return ch.charge(client);

    }

     public JSONObject validateAccountCharge(){

     
        this.apiConnection = new ApiConnection(end.getValidateChargeEndPoint());
      
        ApiQuery api=new ApiQuery();
        
        api.putParams("PBFPubKey",key.getPublicKey());
        api.putParams("transaction_reference", this.getTransaction_reference() );
   //  
        api.putParams("otp", this.getOtp());

        return this.apiConnection.connectAndQuery(api);
    }

    //if timeout, start polling
    public JSONObject handleTimeoutCharge()throws JSONException{
      this.apiConnection = new ApiConnection(end.getChargeTimeoutEndpoint());
      JSONObject json=new JSONObject();
      
       json.put("accountnumber",this.getAccountnumber());//expected result'
       json.put("accountbank",this.getAccountbank());
       json.put("currency", this.getCurrency());
       json.put("country", this.getCountry());
       json.put("amount", this.getAmount());
       json.put("passcode", this.getPasscode());
       json.put("email", this.getEmail());
       json.put("IP", this.getIP());
       json.put("txRef", this.getTxRef());
       json.put("device_fingerprint", this.getDevice_fingerprint());
       json.put("payment_type", this.getPayment_type());
       json.put("firstname", this.getFirstname());
       json.put("lastname", this.getLastname());
      
       
      
         String message= json.toString();
        
        String encrypt_secret_key=e.getKey(key.getSecretKey());
        String client= encryptData(message,encrypt_secret_key);
      
        Charge ch=new Charge();
        
        return ch.charge(client);
    }
      public JSONObject handleTimeoutValidateCharge(){
      this.apiConnection = new ApiConnection(end.getValidateChargeTimeoutEndpoint());
        ApiQuery api=new ApiQuery();
        api.putParams("PBFPubKey", key.getPublicKey());
        api.putParams("transaction_reference", this.getTransaction_reference());
        api.putParams("otp", this.getOtp()); 
    return this.apiConnection.connectAndQuery(api);
    }

    /**
     * @return the accountnumber
     */
    public String getAccountnumber() {
        return accountnumber;
    }

    /**
     * @param accountnumber the accountnumber to set
     */
    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
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
    public void setAccountbank(String accountbank) {
        this.accountbank = accountbank;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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
    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
    public void setLastname(String lastname) {
        this.lastname = lastname;
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
    public void setIP(String IP) {
        this.IP = IP;
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
    public void setTxRef(String txRef) {
        this.txRef = txRef;
    }

    /**
     * @return the payment_type
     */
    public String getPayment_type() {
        return payment_type;
    }

    /**
     * @param payment_type the payment_type to set
     */
    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    /**
     * @return the passcode
     */
    public String getPasscode() {
        return passcode;
    }

    /**
     * @param passcode the passcode to set
     */
    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    /**
     * @return the device_fingerprint
     */
    public String getDevice_fingerprint() {
        return device_fingerprint;
    }

    /**
     * @param device_fingerprint the device_fingerprint to set
     */
    public void setDevice_fingerprint(String device_fingerprint) {
        this.device_fingerprint = device_fingerprint;
    }

    /**
     * @return the transaction_reference
     */
    public String getTransaction_reference() {
        return transaction_reference;
    }

    /**
     * @param transaction_reference the transaction_reference to set
     */
    public void setTransaction_reference(String transaction_reference) {
        this.transaction_reference = transaction_reference;
    }

    /**
     * @return the otp
     */
    public String getOtp() {
        return otp;
    }

    /**
     * @param otp the otp to set
     */
    public void setOtp(String otp) {
        this.otp = otp;
    }
    /**

    * 
    * @return JSONObject
    */
   
    
   
    
}
