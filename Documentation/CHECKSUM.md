## IntegrityChecksum

### Class Name - IntegrityChecksum

#### Method
1. integrityChecksum(HashMap payload)
  - returns `String`(hashed)
#### Note see (https://flutterwavedevelopers.readme.io/docs/checksum).
 
 
#### Sample

```java
      
      IntegrityChecksum ch=new IntegrityChecksum();
    
           ch.setAmount("20")
            .setPayment_method("both")
            .setCustom_description("Pay Internet")
            .setCustom_logo("http://localhost/payporte-3/skin/frontend/ultimo/shoppy/custom/images/logo.svg")
            .setCountry("NG")
            .setCurrency("NGN")
            .setCustomer_email( "user@example.com")
            .setCustomer_firstname("Temi")
            .setCustomer_lastname("Adelewa")
            .setCustomer_phone("234099940409")
            .setTxref("MG-CKSKKHH");
       
       
      String hash= ch.integrityChecksum();

       
```

