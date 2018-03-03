## IntegrityChecksum

### Class Name - IntegrityChecksum

#### Method
1. integrityChecksum(HashMap payload)
  - returns `String`(hashed)
#### Note see (https://flutterwavedevelopers.readme.io/docs/checksum).
 
 
#### Sample

```java
       
         public void test() throws JSONException{
    
      IntegrityChecksum ch=new IntegrityChecksum();
          
        
      HashMap payload=new HashMap();
       
      ch.setAmount("20");
      ch.setPayment_method("both");
      ch.setCustom_description("Pay Internet");
      ch.setCustom_logo("http://localhost/payporte-3/skin/frontend/ultimo/shoppy/custom/images/logo.svg");
      ch.setCountry("NG");
      ch.setCurrency("NGN");
      ch.setCustomer_email( "user@example.com");
      ch.setCustomer_firstname("Temi");
      ch.setCustomer_lastname("Adelewa");
      ch.setCustomer_phone("234099940409");
      ch.setTxref("MG-CKSKKHH");
       
      String hash= ch.integrityChecksum();
}
       
```

