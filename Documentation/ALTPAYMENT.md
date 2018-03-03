## Alternative Payment

### Class Name - AlternativePayment


#### Fields
<<<<<<< HEAD
>accountnumber
>accountbank
>currency
>country
>amount
>firstname
>lastname
>pin
>email
>IP
>txRef
>phonenumber
>orderRef
>network
>flwRef
=======
>txref - This is the merchant's unique transaction reference.

>flwref - This is the payment gateway's unique reference.
    
>>>>>>> 669b00a4d1f8550273617d15dbd518dbc8477d31

#### Methods
1.chargeKenyaMpesa ()

    This charges charge customers using Kenya Mpesa

    returns `JSONObject`

2. chargeGhanaMobileMoney()

    This charges charge customers using Ghana mobile money
    
    returns `JSONObject`

3. chargeNigerianUssd()

    This charges charge customers using nigerian USSD for GTB and Zenith Bank

    returns `JSONObject`


#### Sample

- To use this method you have to encrypt first and pass the encrypted message in the paremter

```java
public static void main(String [] args) throws JSONException{
//for Nigerian ussd
//card charge
JSONObject api=new JSONObject();
Encryption encryption=new Encryption();
AlternativePayment ch=new AlternativePayment();
 ch.setAccountnumber("0690000004");
           ch.setAccountbank("044");
           ch.setCurrency("NGN");
           ch.setCountry("NG");
           ch.setAmount("6000");
           ch.setFirstname("pin");
           ch.setLastname("pin");
           ch.setPin("3310");
           ch.setEmail("sogunledolapo@gmail.com");
           ch.setIP("103.238.105.185");
           ch.setTxRef("MXX-ASC-4578");      
        
        
          JSONObject chargeussd=ch.chargeNigerianUssd();
	  System.out.println(chargeussd);
	  
//for ghana mobile money

      ch.setOrderRef("0690000");
      ch.setNetwork("MTN");
      ch.setCurrency("GHS");
      ch.setCountry("GH");
      ch.setAmount("4000");
      ch.setFirstname("pin");
      ch.setLastname("pin");
      ch.setPin("3310");
      ch.setEmail("sogunledolapo@gmail.com");
      ch.setIP("103.238.105.185");
      ch.setTxRef("MXX-90-49578");
      ch.setPhonenumber("0908467482");
     
      JSONObject chargegh=ch.chargeGhanaMobileMoney();
     
     //for kenya mpesa
  
       ch.setCurrency("KES");
       ch.setCountry("KE");
       ch.setAmount("6000");
       ch.setFirstname("pin");
       ch.setLastname("pin");
       ch.setPin("3310");
       ch.setEmail("sogunledolapo@gmail.com");
       ch.setIP("103.238.105.185");
       ch.setTxRef("MXX-ASC-4578");
       ch.setOrderRef("y77yy");
       ch.setPhonenumber("0903672978");
       
       JSONObject chargempesa=ch.chargeKenyaMpesa();
	
	//complete transaction
	    Transaction t=new Transaction();
            t.setFlwref("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
            JSONObject response=  t.verifyTransactionRequery();
            JSONObject response=  t.verifyTransactionXrequery();
       
   // System.out.println(charge);


}
```
