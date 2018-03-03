## Card Charge

### Class Name - CardCharge


#### Chaining Methods
>setCardno("4187427415564246") `set the card number`
>setCvv("828") `Set the CVV`
>setExpirymonth("09") `set the expiry month`
>setExpiryyear("19") `set the expiry year`
>setCurrency("NGN")  `Set the currency (defaults to NGN) (Optional)`
>setCountry("NG") `Set the country (defaults to Nigeria) (Optional)`
>setPin("3310") `Set The customers pin`
>setSuggested_auth("PIN") `sets the suggested auth`
>setAmount("1000") `Set the amount`
>setEmail("flamekeed@gmail.com")  `Set the customers email`
>setPhonenumber("08020000000")  `Set the customers phone number`
>setFirstname("Oluwole") `Set the customers first name`
>setLastname("Adebiyi") `Set the customers last name`
>setIP("127.0.0.0")  `Set the IP address`
>setTxRef("CA-GHHH-KLJH1234")  `Set the txref`
>setRedirect_url("http://www.google.com")   `Set the redirect url`
>setDevice_fingerprint("GFHGJGU$#%$RGUHU_<GGDGHFG") `set the device finger print(Optional)`
>setCharge_type("preauth") `sets the charge type`
>setTransaction_reference("ACHG-1520028650995") `This is the unique reference/ flwRef, unique to the particular transaction being carried out. It is generated for every transaction. This can be retrieved from the account charge response`
>setOtp("12345") `set the customers otp`

#### Methods

1.  chargeMasterAndVerveCard()

    This charges the clients using mastercard and verve cards


    returns `JSONObject`

2. chargeMasterAndVerveCard(boolean polling)

    This charges the clients using mastercard and verve cards when there is timeout


    returns `JSONObject`

3.  chargeVisaAndIntl()

    This charges the clients using local visa cards and intl cards


    returns `JSONObject`

4.  chargeVisaAndIntl(boolean polling)

    This charges the clients using local visa cards and intl cards when there is timeout


     returns `JSONObject`

5.   validateCardChargeVB()
    
    This validates card charge for visa cards and intl cards
    
    returns `JSONObject`   
    
6.  validateCardCharge(boolean polling)

    This validates card charge for mastercards and verve cards when there is timeout

    returns `JSONObject`   

7.  validateCardCharge()
    
    This validates card charge for mastercards and verve cards

    returns `JSONObject`   


#### Sample

- To use this method you have to set the fields needed and the charge accordingly
```java

CardCharge ch=new CardCharge();
        ch.setCardno("4187427415564246")
          .setCvv("828")
          .setCurrency("NGN")
          .setCountry("NG")
          .setAmount("9000")
          .setExpiryyear("19")
          .setExpirymonth("09")
          .setEmail("sogunledolapo@gmail.com")
          .setIP("103.238.105.185")
          .setTxRef("MXX-ASC-4578")
          .setDevice_fingerprint("69e6b7f0sb72037aa8428b70fbe03986c");
    
        
        //for master card and verve
           ch.setPin("3310")
             .setSuggested_auth("PIN");
             JSONObject charge= ch.chargeMasterAndVerveCard();
            //if timeout
            JSONObject poll=ch.chargeMasterAndVerveCard(true);
   
       //for visa and intl cards
            ch.setRedirect_url("http://www.google.com");
            JSONObject chargevisa=ch.chargeVisaAndIntl();
            //if timeout, poll
            JSONObject pollvisa=ch.chargeVisaAndIntl(true);

	//validate
         ch.setOtp("12345")
           .setTransaction_reference("FLW-MOCK-75dd012dc6c6b58807d69d0e89432e9f");

         JSONObject validateCharge=ch.validateCardCharge();
	 //if timeout, poll
            JSONObject validatepoll=ch.validateCardCharge(true);

	ch.setAuthUrl("");
        ch.validateCardChargeVB();

```

