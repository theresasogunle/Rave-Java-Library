/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;


import static com.rave.Encryption.encryptData;
import static com.rave.Encryption.getKey;
import java.awt.Desktop;
import java.net.URI;
import org.json.JSONException;

import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class CardCharge {
    JSONObject api=new JSONObject();
    Endpoints ed=new Endpoints();
    ApiConnection apiConnection;
    Keys key=new Keys();
    Encryption e=new Encryption();
    private String cardno,cvv,expirymonth,expiryyear,currency,country,pin,suggested_auth,
      amount,email,phonenumber,firstname,lastname,txRef,redirect_url,device_fingerprint,IP,
            charge_type;
    
    
   
    


   private String transactionreference,otp, authUrl;
    /**
    *

    * @param client
    * @return JSONObject
    */
    
   public JSONObject setJSON() throws JSONException{
        JSONObject json=new JSONObject();
        
        json.put("cardno", this.getCardno());
        json.put("cvv", this.getCvv());
        json.put("currency", this.getCurrency());
        json.put("country", this.getCountry());
        json.put("amount", this.getAmount());
        json.put("expiryyear", this.getExpiryyear());
        json.put("expirymonth", this.getExpirymonth());
        json.put("email", this.getEmail());
        json.put("IP", this.getIP());
        json.put("txRef", this.getTxRef());
        json.put("device_fingerprint", this.getDevice_fingerprint());
       // json.put("pin", this.getPin());
        //json.put("suggested_auth", this.getSuggested_auth());
        json.put("firstname", this.getFirstname());
        json.put("lastname", this.getLastname());
        json.put("redirect_url", this.getRedirect_url());
        json.put("charge_type", this.getCharge_type());
        
        return json;
   }
     
    
    public JSONObject chargeMasterAndVerveCard() throws JSONException{
        JSONObject json= setJSON();
        
        json.put("PBFPubKey",key.getPublicKey());
        json.put("pin",this.getPin() );
        json.put("suggested_auth",this.getSuggested_auth() );

        
       String message= json.toString();

        String encrypt_secret_key=getKey(key.getSecretKey());
        String client= encryptData(message,encrypt_secret_key);

        Charge ch=new Charge();

        return ch.charge(client);  
    
    }
    public JSONObject chargeMasterAndVerveCard(boolean polling) throws JSONException{
        JSONObject json= setJSON();
        
        json.put("PBFPubKey",key.getPublicKey());
        json.put("pin",this.getPin() );
        json.put("suggested_auth",this.getSuggested_auth() );
        Polling p=new Polling();

        return p.handleTimeoutCharge(json);
    
    }
    public JSONObject chargeVisaAndIntl() throws JSONException{
        JSONObject json= setJSON();
        json.put("PBFPubKey",key.getPublicKey());
        json.put("redirect_url", this.getRedirect_url() );

        String message= json.toString();

        String encrypt_secret_key=getKey(key.getSecretKey());
        String client= encryptData(message,encrypt_secret_key);

        Charge ch=new Charge();

        return ch.charge(client); 
    
    }
      public JSONObject chargeVisaAndIntl(boolean polling) throws JSONException{
        JSONObject json= setJSON();
        json.put("PBFPubKey",key.getPublicKey());
        json.put("redirect_url", this.getRedirect_url() );
        Polling p=new Polling();

        return p.handleTimeoutCharge(json);
    
    }
    

    /*
    if AuthMode::"PIN"
    @params transaction reference(flwRef),OTP 
    */

    public JSONObject validateCardCharge(){
        Charge vch= new Charge();

        return vch.validateCharge(this.getTransactionreference(), this.getOtp());
    }
    //if timeout
    public JSONObject validateCardCharge(boolean polling){
       
        Polling p=new Polling();
        
        return p.validateChargeTimeout(this.getTransactionreference(), this.getOtp());
    }
    
    /*
    if AuthMode::"VBSECURE"or "AVS_VBVSECURECODE"
    @params authUrl This requires that you copy the authurl returned in the response
    and paste it in the argument and it opens a small window for card validation
    */
    public void validateCardChargeVB(){
     
      if (Desktop.isDesktopSupported()) {
          try{
    Desktop.getDesktop().browse(new URI(this.getAuthUrl()));
          }catch(Exception e){}
            }
    }
   

    /**
     * @return the cardno
     */
    public String getCardno() {
        return cardno;
    }

    /**
     * @param cardno the cardno to set
     */
    public CardCharge setCardno(String cardno) {
        this.cardno = cardno;
        
        return this;
    }

    /**
     * @return the cvv
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * @param cvv the cvv to set
     */
    public CardCharge setCvv(String cvv) {
        this.cvv = cvv;
        
        return this;
    }

    /**
     * @return the expirymonth
     */
    public String getExpirymonth() {
        return expirymonth;
    }

    /**
     * @param expirymonth the expirymonth to set
     */
    public CardCharge setExpirymonth(String expirymonth) {
        this.expirymonth = expirymonth;
        
        return this;
    }

    /**
     * @return the expiryyear
     */
    public String getExpiryyear() {
        return expiryyear;
    }

    /**
     * @param expiryyear the expiryyear to set
     */
    public CardCharge setExpiryyear(String expiryyear) {
        this.expiryyear = expiryyear;
        
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
    public CardCharge setCurrency(String currency) {
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
    public CardCharge setCountry(String country) {
        this.country = country;
        
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
    public CardCharge setPin(String pin) {
        this.pin = pin;
        
        return this;
    }

    /**
     * @return the suggested_auth
     */
    public String getSuggested_auth() {
        return suggested_auth;
    }

    /**
     * @param suggested_auth the suggested_auth to set
     */
    public CardCharge setSuggested_auth(String suggested_auth) {
        this.suggested_auth = suggested_auth;
        
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
    public CardCharge setAmount(String amount) {
        this.amount = amount;
        
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
    public CardCharge setEmail(String email) {
        this.email = email;
        
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
    public CardCharge setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        
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
    public CardCharge setFirstname(String firstname) {
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
    public CardCharge setLastname(String lastname) {
        this.lastname = lastname;
        
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
    public CardCharge setIP(String IP) {
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
    public CardCharge setTxRef(String txRef) {
        this.txRef = txRef;
        
        return this;
    }

    /**
     * @return the redirect_url
     */
    public String getRedirect_url() {
        return redirect_url;
    }

    /**
     * @param redirect_url the redirect_url to set
     */
    public CardCharge setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
        
        return this;
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
    public CardCharge setDevice_fingerprint(String device_fingerprint) {
        this.device_fingerprint = device_fingerprint;
        
        return this;
    }

    /**
     * @return the charge_type
     */
    public String getCharge_type() {
        return charge_type;
    }

    /**
     * @param charge_type the charge_type to set
     */
    public CardCharge setCharge_type(String charge_type) {
        this.charge_type = charge_type;
        
        return this;
    }

    /**
     * @return the transaction_reference
     */
    public String getTransactionreference() {
        return transactionreference;
    }

    /**
     * @param transaction_reference the transaction_reference to set
     */
    public CardCharge setTransactionreference(String transaction_reference) {
        this.transactionreference= transaction_reference;
        
        return this;
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
    public CardCharge setOtp(String otp) {
        this.otp = otp;
        
        return this;
    }

    /**
     * @return the authUrl
     */
    public String getAuthUrl() {
        return authUrl;
    }

    /**
     * @param authUrl the authUrl to set
     */
    public CardCharge setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
        
        return this;
    }
}
