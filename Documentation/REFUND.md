## Refund

### Class Name - Refund

#### Methods
1. refund(String ref)

    This method allows you initiate refunds for Successful transactions
    
    **Parameters**
    
    >ref - This is the flwRef returned in the charge response
    
    returns `JSONObject`
    
 
 
#### Sample

```java
Refund rf=new Refund();
System.out.println(rf.refund("FLW-MOCK-d310263f5f73e51d01e6dab32c893679"));
```

