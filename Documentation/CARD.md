## Card Charge

### Class Name - CardCharge

<<<<<<< HEAD
#### Fields
	 >transaction_reference(flwref) - This is the transaction reference
    
    	>otp
=======
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
#### Methods
1. chargeCard(String client)

    This charges the clients visa,mastercard,intl and verve cards

    **Parameters**
    
    >client - This is the encrypted client details gotten from the [encryption method](ENCRYPTION.md)

    returns `JSONObject`

2. validateCardCharge(String transaction_reference, String otp)
    
    This validates account charge
    
    **Parameters**
    
    >transaction_reference - This is the transaction reference
    
    >otp
    
    returns `JSONObject`
    
    
 
 
#### Sample

- To use this method you have to encrypt first and pass the encrypted message in the paremter

```java
JSONObject api=new JSONObject();
Encryption encryption=new Encryption();
CardCharge ch=new CardCharge();

//card charge
try{
api.put("cardno", "5438898014560229");
api.put("cvv", "789");
api.put("currency", "NGN");
api.put("country", "NG");
api.put("amount", "6000");
api.put("expiryyear", "19");
api.put("expirymonth", "09");
api.put("suggested_auth", "pin");
api.put("pin", "3310");
api.put("email", "sogunledolapo@gmail.com");
api.put("IP", "103.238.105.185");
api.put("txRef", "MXX-ASC-4578");
api.put("device_fingerprint", "69e6b7f0sb72037aa8428b70fbe03986c");

}catch(Exception ex){}
String encrypted_message= encryption.encryptParameters(api);


// JSONObject charge=ch.chargeCard(encrypted_message);
<<<<<<< HEAD
   ch.transaction_reference="FLW-MOCK-XXXXXXXXXXXXXXXXXXXXXXXXXXXX";
   ch.otp="123456";
// JSONObject validateCharge=ch.validateCardCharge();
=======

// JSONObject validateCharge=ch.validateCardCharge("FLW-MOCK-d310263f5f73e51d01e6dab32c893679", "12345");
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4

//  System.out.println(validateCharge);
```

