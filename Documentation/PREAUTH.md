## PreAuthorization

### Class Name - Fees
<<<<<<< HEAD
 >flwRef(ref) - This is the payment gateway's unique reference.
 >action - This is the action to be taken i.e. `refund` or `void`
#### Fields

#### Methods
1. preAuthorizeCard(String client)
=======

#### Methods
1. preAuthorizeCard(String encrypted_message)
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4

    >client - This is the encrypted client details gotten from the [encryption method](ENCRYPTION.md)

    returns `JSONObject`
    
2. capture(String flwRef)
    >flwRef - This is the payment gateway's unique reference.
    
    returns `JSONObject`
    
<<<<<<< HEAD
3. refundOrVoid()
=======
3. refundOrVoid(String ref,String action)
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
    >ref - This is the `flwRef` returned in the `capture response.`
    >action - This is the action to be taken i.e. `refund` or `void`
 
 
#### Sample

```java
JSONObject api=new JSONObject();
Encryption encryption=new Encryption();
PreAuthorization ch=new PreAuthorization();

//card charge
try{

    api.put("cardno", "5438898014560229");
    api.put("charge_type","preauth");
    api.put("cvv", "812");
    api.put("expirymonth", "08");
    api.put("expiryyear","20");
    api.put( "currency", "NGN");
    api.put("country", "NG");
    api.put("amount", "100");
    api.put("email", "user@example.com");
    api.put("phonenumber", "08056552980");
    api.put("firstname", "user");
    api.put("lastname", "example");
    api.put("IP", "40.198.14");
    api.put("txRef", "MXX-ASC-4578");
    api.put("redirect_url", "https://rave-web.herokuapp.com/receivepayment");
    api.put("device_fingerprint", "69e6b7f0b72037aa8428b70fbe03986c");

}catch(Exception ex){}
String encrypted_message= encryption.encryptParameters(api);


JSONObject charge=ch.preAuthorizeCard(encrypted_message);
<<<<<<< HEAD
ch.flwRef=""FLW-MOCK-d310263f5f73e51d01e6dab32c893679";
ch.action="refund";
JSONObject capture=ch.capture();
JSONObject refundOrVoid=ch.refundOrVoid();
=======

JSONObject capture=ch.capture("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
JSONObject refundOrVoid=ch.refundOrVoid("FLW-MOCK-d310263f5f73e51d01e6dab32c893679","refund");
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4


System.out.println(charge);
```

