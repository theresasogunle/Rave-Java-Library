## Account Charge

### Class Name - AccountCharge

#### Methods
1. chargeAccount(String client)

    This charges the clients account

    **Parameters**
    
    >client - This is the encrypted client details gotten from the [encryption method](ENCRYPTION.md)

    returns `JSONObject`

2. validateAccountCharge(String transaction_reference, String otp)
    
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
AccountCharge ch=new AccountCharge();

//card charge
try{
api.put("accountnumber", "0690000004");
api.put("accountbank", "044");
api.put("currency", "NGN");
api.put("country", "NG");
api.put("amount", "6000");
api.put("firstname", "pin");
api.put("lastname", "pin");
api.put("pin", "3310");
api.put("email", "flamekeed@gmail.com");
api.put("IP", "103.238.105.185");
api.put("txRef", "MXX-ASC-4578");
api.put("payment_type", "account");

}catch(Exception ex){}
String encrypted_message= encryption.encryptParameters(api);

JSONObject res=ch.chargeAccount(encrypted_message);

JSONObject val=ch.validateAccountCharge("ACHG-1519428047882", "12345");
```

