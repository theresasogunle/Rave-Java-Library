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


2. validateAccountCharge()

    
    This validates account charge
    
    **Parameters**
    
    >transaction_reference - This is the transaction reference
    
    >otp
    
    returns `JSONObject`
    
    
 
 
#### Sample

- To use this method you have to encrypt first and pass the encrypted message in the paremter

```java


AccountCharge ch=new AccountCharge();


//account charge parameters


 AccountCharge ch=new AccountCharge();
        
            ch.setAccountnumber("0690000031");
            ch.setAccountbank("044");
            ch.setAmount("1000");
            ch.setCountry("NG");
            ch.setCurrency("NGN");
            ch.setLastname("Theresa");
            ch.setIP("1.3.4.4");
            ch.setPayment_type("account");
            ch.setTxRef("MX-678DH");
            ch.setEmail("sogunledolapo@gmail.com");
          
          
           JSONObject result=ch.chargeAccount();
       

        //validate
        ch.setTransaction_reference("ACHG-1520028650995");
        ch.setOtp("12345"); 
        JSONObject val=ch.validateAccountCharge();

        System.out.println(val);

```

