## Refund

### Class Name - Refund

#### Fields
  >ref - This is the flwRef returned in the charge response


#### Methods
1. refund()

    This method allows you initiate refunds for Successful transactions
    
    **Parameters**
    
    >ref - This is the flwRef returned in the charge response
    
    returns `JSONObject`
    
 
 
#### Sample

```java
Refund rf=new Refund();

rf.ref="FLW-MOCK-d310263f5f73e51d01e6dab32c893679";
System.out.println(rf.refund());

```

