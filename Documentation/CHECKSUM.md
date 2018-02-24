## IntegrityChecksum

### Class Name - IntegrityChecksum

#### Method
1. integrityChecksum(HashMap payload)
  - returns `String`(hashed)
#### Note see (https://flutterwavedevelopers.readme.io/docs/checksum).
 
 
#### Sample

```java
          Date d=new Date();
          IntegrityChecksum ch=new IntegrityChecksum();
  HashMap payload=new HashMap();
       
    
      payload.put("amount" ,"20");
      payload.put("payment_method", "both");
      payload.put("custom_description","Pay Internet");
       payload.put("custom_logo","http://localhost/payporte-3/skin/frontend/ultimo/shoppy/custom/images/logo.svg");
       payload.put("country", "NG");
       payload.put("currency", "NGN");
       payload.put ("customer_email", "user@example.com");
       payload.put(  "customer_firstname", "Temi");
       payload.put("customer_lastname", "Adelewa");
       payload.put("customer_phone", "234099940409");
       payload.put( "txref","MG-"+d.getDate());
       
      String hash= ch.integrityChecksum(payload);
          System.out.println(hash);
       
```

