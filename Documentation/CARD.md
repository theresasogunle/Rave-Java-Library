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

