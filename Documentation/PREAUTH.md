## PreAuthorization

### Class Name - Fees

 
#### Fields
 >flwRef(ref) - This is the payment gateway's unique reference.
 >action - This is the action to be taken i.e. `refund` or `void`
#### Methods
1. preAuthorizeCard(String client)

    >client - This is the encrypted client details gotten from the [encryption method](ENCRYPTION.md)

    returns `JSONObject`
    
2. capture(String flwRef)
    >flwRef - This is the payment gateway's unique reference.
    
    returns `JSONObject`
    

3. refundOrVoid()
=======
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

ch.flwRef=""FLW-MOCK-d310263f5f73e51d01e6dab32c893679";
ch.action="refund";
JSONObject capture=ch.capture();
JSONObject refundOrVoid=ch.refundOrVoid();


System.out.println(charge);
```

