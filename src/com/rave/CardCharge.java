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
      amount,email,phonenumber,firstname,lastname,IP,txRef,redirect_url,device_fingerprint,
            charge_type;
    


   private String transaction_reference,otp, authUrl;
    /**
    *

    * @param client
    * @return JSONObject
    */
    //charge visa,mastercard,intl and verve cards
    public JSONObject chargeCard() throws JSONException{
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
       json.put("pin", this.getPin());
       json.put("suggested_auth", this.getSuggested_auth());
       json.put("firstname", this.getFirstname());
       json.put("lastname", this.getLastname());
       json.put("redirect_url", this.getRedirect_url());
       json.put("charge_type", this.getCharge_type());
       
         String message= json.toString();
        
        String encrypt_secret_key=e.getKey(key.getSecretKey());
        String client= encryptData(message,encrypt_secret_key);
      
        Charge ch=new Charge();
        
        return ch.charge(client);   
    }
    public JSONObject chargeMasterAndVerveCard() throws JSONException{
           JSONObject json= new JSONObject();
            json.put("PBFPubKey",key.getPublicKey());
            json.put("pin",this.getPin() );
            json.put("suggested_auth",this.getSuggested_auth() );
        
       
        String message= json.toString();
        
        String encrypt_secret_key=getKey(key.getSecretKey());
        String client= encryptData(message,encrypt_secret_key);

         Charge ch=new Charge();
           
        return ch.charge(client);  
    
    }
    
    public JSONObject chargeVisaAndIntl() throws JSONException{
             JSONObject json= new JSONObject();
            json.put("PBFPubKey",key.getPublicKey());
            json.put("redirect_url", this.getRedirect_url() );
         
            String message= json.toString();
        
        String encrypt_secret_key=getKey(key.getSecretKey());
        String client= encryptData(message,encrypt_secret_key);

         Charge ch=new Charge();
           
        return ch.charge(client); 
    
    }
    

    /*
    if AuthMode::"PIN"
    @params transaction reference(flwRef),OTP 
    */

    public JSONObject validateCardCharge(){
        this.apiConnection = new ApiConnection(ed.getValidateChargeEndPoint());
      
        ApiQuery api=new ApiQuery();
        
        api.putParams("PBFPubKey",key.getPublicKey());
        api.putParams("transaction_reference",this.getTransaction_reference());
     api.putParams("otp", this.getOtp());

        return this.apiConnection.connectAndQuery(api);
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
    //if timeout, start polling
    public JSONObject handleTimeoutCharge()throws JSONException{
      this.apiConnection = new ApiConnection(ed.getChargeTimeoutEndpoint());
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
       json.put("pin", this.getPin());
       json.put("suggested_auth", this.getSuggested_auth());
       json.put("firstname", this.getFirstname());
       json.put("lastname", this.getLastname());
       json.put("redirect_url", this.getRedirect_url());
       json.put("charge_type", this.getCharge_type());
       
      
         String message= json.toString();
        
        String encrypt_secret_key=e.getKey(key.getSecretKey());
        String client= encryptData(message,encrypt_secret_key);
      
        Charge ch=new Charge();
        
        return ch.charge(client);
    }
    
    //if timeout, start polling
      public JSONObject handleTimeoutValidateCharge(){
      this.apiConnection = new ApiConnection(ed.getValidateChargeTimeoutEndpoint());
        ApiQuery api=new ApiQuery();
        api.putParams("PBFPubKey", key.getPublicKey());
        api.putParams("transaction_reference", this.getTransaction_reference());
        api.putParams("otp", this.getOtp()); 
    return this.apiConnection.connectAndQuery(api);
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
    public void setCardno(String cardno) {
        this.cardno = cardno;
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
    public void setCvv(String cvv) {
        this.cvv = cvv;
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
    public void setExpirymonth(String expirymonth) {
        this.expirymonth = expirymonth;
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
    public void setExpiryyear(String expiryyear) {
        this.expiryyear = expiryyear;
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
     * @return the pin
     */
    public String getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(String pin) {
        this.pin = pin;
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
    public void setSuggested_auth(String suggested_auth) {
        this.suggested_auth = suggested_auth;
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
     * @return the redirect_url
     */
    public String getRedirect_url() {
        return redirect_url;
    }

    /**
     * @param redirect_url the redirect_url to set
     */
    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
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
     * @return the charge_type
     */
    public String getCharge_type() {
        return charge_type;
    }

    /**
     * @param charge_type the charge_type to set
     */
    public void setCharge_type(String charge_type) {
        this.charge_type = charge_type;
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
     * @return the authUrl
     */
    public String getAuthUrl() {
        return authUrl;
    }

    /**
     * @param authUrl the authUrl to set
     */
    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }
}
