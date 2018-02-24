## Encryption

### Class Name - Encryption

#### Methods
1. encryptParameters(JSONObject params)

    This is used for encryption of parameters

    **Parameters**
    
    >params - This is the  parameters we need to encrypt, accepts JSONObject

    returns `String`

2. encryptParametersPreAuth(JSONObject params)
    
    This encrypts pre auth parameters
    
    **Parameters**
    
    >params - This is the  parameters we need to encrypt, accepts JSONObject
    
    returns `String`
    
    
 
 
#### Sample

- To use this method you have to encrypt first and pass the encrypted message in the paremter

```java
JSONObject api=new JSONObject();
Encryption encryption=new Encryption();

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

```

