## Account Charge

### Class Name - AccountCharge


#### Chaining Methods
>setAccountnumber("0690000031") `Set the customers account number`
>setAccountbank("044") `Set the bank shortcode`
>setCurrency("NGN")  `Set the currency (defaults to NGN) (Optional)`
>setCountry("NG") `Set the country (defaults to Nigeria) (Optional)`
>setAmount("1000") `Set the amount`
>setEmail("flamekeed@gmail.com")  `Set the customers email`
>setPhonenumber("08020000000")  `Set the customers phone number`
>setFirstname("Oluwole") `Set the customers first name`
>setLastname("Adebiyi") `Set the customers last name`
>setIP("127.0.0.0")  `Set the IP address`
>setTxRef("CA-GHHH-KLJH1234")  `Set the txref`
>setDevice_fingerprint("GFHGJGU$#%$RGUHU_<GGDGHFG") `set the device finger print(Optional)`
>setTransaction_reference("ACHG-1520028650995") `This is the unique reference/ flwRef, unique to the particular transaction being carried out. It is generated for every transaction. This can be retrieved from the account charge response`
>setOtp("12345") `set the customers otp`

#### Methods
1. chargeAccount()

    This charges the clients account    
   
    returns `JSONObject`

2. chargeAccount(boolean polling)

    pooling=true

    This charges client account when theres timeout.
    
    **Parameters**
    
   
    returns `JSONObject`

3. validateAccountCharge()

    
    This validates account charge
    
    returns `JSONObject`
    
3. validateAccountCharge(boolean polling)

    pooling=true

    This validates account charge when theres timeout.
    
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

