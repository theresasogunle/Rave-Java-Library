## Alternative Payment

### Class Name - AlternativePayment


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
>setPin("3310") `Set The customers pin`
>setIP("127.0.0.0")  `Set the IP address`
>setTxRef("CA-GHHH-KLJH1234")  `Set the txref`
>setOrderRef("CA-GHHH-KLJH1234") `Unique ref for the mpesa transaction to be provided by the merchant.`
>setNetwork("MTN") `This is the customer's mobile money network provider.`
>setFlwRef("FLW-MOCK-d310263f5f73e51d01e6dab32c893679") `This is the payment gateway's unique reference.`


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
           ch.setAccountnumber("0690000004")
             .setAccountbank("044")
             .setCurrency("NGN")
             .setCountry("NG")
             .setAmount("6000")
             .setFirstname("pin")
             .setLastname("pin")
             .setPin("3310")
             .setEmail("sogunledolapo@gmail.com")
             .setIP("103.238.105.185")
             .setTxRef("MXX-ASC-4578");    
        
        
          JSONObject chargeussd=ch.chargeNigerianUssd();
	  System.out.println(chargeussd);
	  
//for ghana mobile money

     ch.setOrderRef("0690000")
        .setNetwork("MTN")
        .setCurrency("GHS")
        .setCountry("GH")
        .setAmount("4000")
        .setFirstname("pin")
        .setLastname("pin")
        .setPin("3310")
        .setEmail("sogunledolapo@gmail.com")
        .setIP("103.238.105.185")
        .setTxRef("MXX-90-49578")
       .setPhonenumber("08020000000");
     
      JSONObject chargegh=ch.chargeGhanaMobileMoney();
     
     //for kenya mpesa
  
      ch.setCurrency("KES")
         .setCountry("KE")
         .setAmount("6000")
         .setFirstname("pin")
         .setLastname("pin")
         .setPin("3310")
         .setEmail("sogunledolapo@gmail.com")
         .setIP("103.238.105.185")
         .setTxRef("MXX-ASC-4578")
         .setOrderRef("y77yy")
         .setPhonenumber("0903672978");
       
       JSONObject chargempesa=ch.chargeKenyaMpesa();
	
	//complete transaction
	    Transaction t=new Transaction();
            t.setFlwref("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
	       .setTxRef("");
            JSONObject response=  t.verifyTransactionRequery();
            JSONObject response=  t.verifyTransactionXrequery();
       
   // System.out.println(charge);


}
```
