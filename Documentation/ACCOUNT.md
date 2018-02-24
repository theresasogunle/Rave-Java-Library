## Account Charge

### Class Name - AccountCharge

<<<<<<< HEAD
#### Fields
>transaction_reference( This is the 'flwRef')
>otp
=======
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
#### Methods
1. chargeAccount(String client)

    This charges the clients account

    **Parameters**
    
    >client - This is the encrypted client details gotten from the [encryption method](ENCRYPTION.md)

    returns `JSONObject`

<<<<<<< HEAD
2. validateAccountCharge()
=======
2. validateAccountCharge(String transaction_reference, String otp)
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
    
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

<<<<<<< HEAD
//account charge parameters
=======
//card charge
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
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
<<<<<<< HEAD
//encrypting parameters
String encrypted_message= encryption.encryptParameters(api);
//charge account
JSONObject res=ch.chargeAccount(encrypted_message);
//to validate account charge
  	ch.otp="12345";
        ch.transaction_reference="ACHG-1519428047882";
        JSONObject val=ch.validateAccountCharge();
=======
String encrypted_message= encryption.encryptParameters(api);

JSONObject res=ch.chargeAccount(encrypted_message);

JSONObject val=ch.validateAccountCharge("ACHG-1519428047882", "12345");
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
```

