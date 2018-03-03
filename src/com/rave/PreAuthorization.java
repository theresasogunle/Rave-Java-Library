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
public class PreAuthorization {
   ApiConnection apiConnection;
   Endpoints end=new Endpoints();
   Encryption e=new Encryption();
    private String flwref;
    private String action;
  Keys key=new Keys();
  private String cardno,cvv,expirymonth,expiryyear,currency,country,
      amount,email,phonenumber,firstname,lastname,IP,txRef,redirect_url,device_fingerprint,
            charge_type;
  /*
  NB: For Preauth payment please use the keys below:
| Public Key | FLWPUBK-8cd258c49f38e05292e5472b2b15906e-X |
| Secret Key | FLWSECK-c51891678d48c39eff3701ff686bdb69-X |

    Preauth payments is based on approval per merchant,
  and is not open to accounts except approval to use these payment method is given.
  */
   public JSONObject preAuthorizeCard()throws JSONException{
       
      this.apiConnection = new ApiConnection(end.getChargeEndPoint());
      JSONObject json= new JSONObject();
       
      //preauthorization requires special public key
      String public_key="FLWPUBK-8cd258c49f38e05292e5472b2b15906e-X ";
      
      //else us the normal public key
     //  String public_key=key.getPublicKey();
        json.put("PBFPubKey",public_key);
        json.put("cardno", this.getCardno());
        json.put("charge_type",this.getCharge_type());
        json.put("cvv", this.getCvv());
        json.put("expirymonth", this.getExpirymonth());
        json.put("expiryyear",this.getExpiryyear());
        json.put( "currency", this.getCurrency());
        json.put("country", this.getCountry());
        json.put("amount",this.getAmount());
        json.put("email", this.getEmail());
        json.put("phonenumber", this.getPhonenumber());
        json.put("firstname", this.getFirstname());
        json.put("lastname", this.getLastname());
        json.put("IP", this.getIP());
        json.put("txRef", this.getTxRef());
        json.put("redirect_url", this.getRedirect_url());
        json.put("device_fingerprint", this.getDevice_fingerprint());
      
      //preauthorization requires special public key
      
         String message= json.toString();
         String secret_key="FLWSECK-c51891678d48c39eff3701ff686bdb69-X";
         
        String encrypt_secret_key=e.getKey(secret_key);
        String client= encryptData(message,encrypt_secret_key);
       String alg="3DES-24";
       
       ApiQuery api=new ApiQuery();
         
        api.putParams("PBFPubKey", public_key);
        api.putParams("client", client);
        api.putParams("alg", alg);
        System.out.println("Succesful");
       
       
          return this.apiConnection.connectAndQuery(api);
   }
   
   public JSONObject capture(){
      this.apiConnection = new ApiConnection(end.getCaptureEndPoint());
      ApiQuery api= new ApiQuery();
    
      String secret_key="FLWSECK-c51891678d48c39eff3701ff686bdb69-X";

     // String secret_key=key.getSecretKey();
      api.putParams("flwRef", this.getFlwref());
      api.putParams("SECKEY", secret_key);
      
    
      return this.apiConnection.connectAndQuery(api);
   }
   
   public JSONObject refundOrVoid(){
   this.apiConnection = new ApiConnection(end.getRefundOrVoidEndPoint());
    ApiQuery api= new ApiQuery();
     String secret_key="FLWSECK-c51891678d48c39eff3701ff686bdb69-X";
     // String secret_key=key.getSecretKey();
      api.putParams("ref", this.getFlwref());
      api.putParams("action", this.getAction());
      api.putParams("SECKEY", secret_key);
    
      return this.apiConnection.connectAndQuery(api);
   
   }

    /**
     * @return the flwref
     */
    public String getFlwref() {
        return flwref;
    }

    /**
     * @param flwref the flwref to set
     */
    public void setFlwref(String flwref) {
        this.flwref = flwref;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
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
}
