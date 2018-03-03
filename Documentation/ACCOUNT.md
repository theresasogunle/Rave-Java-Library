## Account Charge

### Class Name - AccountCharge


#### Fields
>accountnumber
>accountbank
>currency
>country
>amount
>email
>phonenumber
>firstname
>lastname
>IP
>txRef
>payment_type
>passcode
device_fingerprint
>transaction_reference
>otp

#### Methods
1. chargeAccount()

    This charges the clients account

    **Parameters**
    
   
    returns `JSONObject`

2. chargeAccount(boolean polling)

    pooling=true

    This charges client account when theres timeout.
    
    **Parameters**
    
   
    returns `JSONObject`

3. validateAccountCharge()

    
    This validates account charge
    
    **Parameters**
    
    >transaction_reference - This is the transaction reference
    
    >otp
    
    returns `JSONObject`
    
3. validateAccountCharge(boolean polling)

    pooling=true

    This validates account charge when theres timeout.
    
    **Parameters**
    
    >transaction_reference - This is the transaction reference
    
    >otp
    
    returns `JSONObject`
        
 
 
#### Sample

- To use this method you have to encrypt first and pass the encrypted message in the paremter

```java




//account charge parameters


 AccountCharge ch=new AccountCharge();

         ch.setAccountnumber("0690000031")
            .setAccountbank("044")
            .setAmount("1000")
            .setCountry("NG")
            .setCurrency("NGN")
            .setLastname("Theresa")
            .setIP("1.3.4.4")
            .setPayment_type("account")
            .setTxRef("MX-678DH")
            .setEmail("sogunledolapo@gmail.com");
          
          
          //charge account normally
           JSONObject result=ch.chargeAccount();
           
	   //polling
            JSONObject poll=ch.chargeAccount(true);

          //validate
          ch.setTransaction_reference("ACHG-1520028650995");
            .setOtp("12345"); 

         JSONObject val=ch.validateAccountCharge();
	 //for polling
        JSONObject val=ch.validateAccountCharge(true);

        System.out.println(val);

```

