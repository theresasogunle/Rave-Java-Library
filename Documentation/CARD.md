## Card Charge

### Class Name - CardCharge


#### Fields
>cardno
>cvv
>expirymonth
>expiryyear
>currency
>country
>pin
>suggested_auth
>amount
>email
>phonenumber
>firstname
>lastname
>IP
>txRef
>redirect_url
>device_fingerprint
>charge_type
>transaction_reference(flwref) - This is the transaction reference
>otp

#### Methods
1. chargeCard()

    This charges the clients visa,mastercard,intl and verve cards

    returns `JSONObject`

2.  chargeMasterAndVerveCard()

    This charges the clients using mastercard and verve cards


    returns `JSONObject`

3.  chargeVisaAndIntl()

    This charges the clients using local visa cards and intl cards


    returns `JSONObject`

4.  validateCardCharge()
    
    This validates card charge for mastercards and verve cards
    
    returns `JSONObject`

5.   validateCardChargeVB()
    
    This validates card charge for visa cards and intl cards
    
    returns `JSONObject`   
    
6.   handleTimeoutCharge()
    
    for polling timeouts, alternative is by using the Polling class
    
    returns `JSONObject`   

7. handleTimeoutValidateCharge()
    
    for polling timeouts, alternative is by using the Polling class
    
    returns `JSONObject`        
 
#### Sample

- To use this method you have to set the fields needed and the charge accordingly
```java

CardCharge ch=new CardCharge();
public static void main(String[] args) throws JSONException{
//card charge
 ch.setCardno("4187427415564246");
       ch.setCvv("828");
       ch.setCurrency("NGN");
       ch.setCountry("NG");
       ch.setAmount("9000");
       ch.setExpiryyear("19");
       ch.setExpirymonth("09");
       ch.setEmail("sogunledolapo@gmail.com");
       ch.setIP("103.238.105.185");
       ch.setTxRef("MXX-ASC-4578");
       ch.setDevice_fingerprint("69e6b7f0sb72037aa8428b70fbe03986c");
     
      
         //for master card and verve
       ch.setPin("3310");
       ch.setSuggested_auth("PIN");
       JSONObject charge= ch.chargeMasterAndVerveCard();
       
       //for visa and intl cards
        ch.setRedirect_url("http://www.google.com");
        JSONObject chargevisa=ch.chargeVisaAndIntl();

	//validate
         ch.setOtp("12345");
         ch.setTransaction_reference("FLW-MOCK-75dd012dc6c6b58807d69d0e89432e9f");
         JSONObject validateCharge=ch.validateCardCharge();

	 ch.setAuthUrl("");
        ch.validateCardChargeVB();
}
```

