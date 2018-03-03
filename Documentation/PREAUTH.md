## PreAuthorization

### Class Name - Fees

 
#### Fields
<<<<<<< HEAD
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
>flwRef(ref) - This is the payment gateway's unique reference.
>action - This is the action to be taken i.e. `refund` or `void`
=======
 >flwRef(ref) - This is the payment gateway's unique reference.
 
 >action - This is the action to be taken i.e. `refund` or `void`
>>>>>>> 669b00a4d1f8550273617d15dbd518dbc8477d31
#### Methods
1. preAuthorizeCard()

   

    returns `JSONObject`
    
2. capture()
    >flwRef - This is the payment gateway's unique reference.
    
    returns `JSONObject`
    

3. refundOrVoid()

    >ref - This is the `flwRef` returned in the `capture response.`
    
    >action - This is the action to be taken i.e. `refund` or `void`
 
 
#### Sample

```java

PreAuthorization ch=new PreAuthorization();

//card charge
  ch.setCharge_type("preauth");
        ch.setCvv("812");
        ch.setExpirymonth("08");
        ch.setExpiryyear("20");
        ch.setCurrency("NGN");
        ch.setCountry("NG");
        ch.setAmount("100");
        ch.setEmail("user@example.com");
        ch.setPhonenumber("08056552980");
        ch.setFirstname("user");
        ch.setLastname("example");
        ch.setIP("40.198.14");
        ch.setTxRef("MXX-ASC-4578");
        ch.setRedirect_url("https://rave-web.herokuapp.com/receivepayment");
        ch.setDevice_fingerprint("69e6b7f0b72037aa8428b70fbe03986c"); 
       
       
        JSONObject response=ch.preAuthorizeCard();
        
       
            ch.setFlwref("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
            ch.setAction("refund");
            JSONObject capture=  ch.capture();
            JSONObject refund= ch.refundOrVoid();
       
```

