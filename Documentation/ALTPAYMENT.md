## Alternative Payment

### Class Name - AlternativePayment


#### Fields
>txref - This is the merchant's unique transaction reference.

>flwref - This is the payment gateway's unique reference.
    

#### Methods
1. alternativePaymentCharge(String client)

    This charges charge customers using nigerian USSD for GTB and Zenith Bank,Ghana mobile money and Kenya Mpesa

    **Parameters**
    
    >client - This is the encrypted client details gotten from the [encryption method](ENCRYPTION.md)

    returns `JSONObject`


2. completeTransactionWithXrequery()
    
    To verify/requery transaction for ghana mobile money,kenya mpesa and nigerian ussd using your transaction reference
    
    **Parameters**
    
    >txref - This is the merchant's unique transaction reference.
    
    >flwref - This is the payment gateway's unique reference.
    
    * You can use either `txref` or `flwref` or both
    
    returns `JSONObject`
    

3. completeTransactionRequery()

    To verify/requery transaction for ghana mobile money,kenya mpesa and nigerian ussd using your flwref
    
    **Parameters**
    
    >flwref - This is the payment gateway's unique reference.
    

#### Sample

- To use this method you have to encrypt first and pass the encrypted message in the paremter

```java
public static void main(String [] args){
//for Nigerian ussd
//card charge
JSONObject api=new JSONObject();
Encryption encryption=new Encryption();
AlternativePayment ch=new AlternativePayment();
try{
       //available for only zenith and GTB
   api.put("accountnumber", "0690000004");
   api.put("accountbank", "044");
   api.put("currency", "NGN");
   api.put("country", "NG");
   api.put("amount", "6000");
   api.put("firstname", "pin");
   api.put("lastname", "pin");
   api.put("pin", "3310");
   api.put("email", "sogunledolapo@gmail.com");
   api.put("IP", "103.238.105.185");
   api.put("txRef", "MXX-ASC-4578");
   api.put("payment_type", "ussd");
   
   
}catch(Exception ex){}
String encrypted_message= encryption.encryptParameters(api);
//for ghana mobile money
   
try{
   api.put("orderRef", "0690000004");
   api.put("network", "MTN");
   api.put("currency", "NGN");
   api.put("country", "NG");
   api.put("amount", "6000");
   api.put("firstname", "pin");
   api.put("lastname", "pin");
   api.put("pin", "3310");
   api.put("email", "sogunledolapo@gmail.com");
   api.put("IP", "103.238.105.185");
   api.put("txRef", "MXX-ASC-4578");
   api.put("payment_type", "mobilemoneygh");
   api.put("is_mobile_money_gh", "1");
   
}catch(Exception ex){}
//  String encrypted_message= encryption.encryptParameters(api);
     
     //for kenya mpesa
try{
   
   api.put("currency", "NGN");
   api.put("country", "NG");
   api.put("amount", "6000");
   api.put("firstname", "pin");
   api.put("lastname", "pin");
   api.put("pin", "3310");
   api.put("email", "sogunledolapo@gmail.com");
   api.put("IP", "103.238.105.185");
   api.put("txRef", "MXX-ASC-4578");
   api.put("payment_type", "mpesa");
   api.put("is_mpesa", "1");
   api.put("orderRef", "");
   
}catch(Exception ex){}

JSONObject charge=ch.alternativePaymentCharge(encrypted_message);


	
	JSONObject charge=ch.alternativePaymentCharge(encrypted_message);
       //verify transaction
	 ch.flwref="FLW-MOCK-d310263f5f73e51d01e6dab32c893679";
	 ch.completeTransactionRequery();
	 ch.completeTransactionWithXrequery();
       
   // System.out.println(charge);


}
```
