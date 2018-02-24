## Refund

### Class Name - Refund

<<<<<<< HEAD
#### Fields
  >ref - This is the flwRef returned in the charge response

=======
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
#### Methods
1. refund(String ref)

    This method allows you initiate refunds for Successful transactions
    
    **Parameters**
    
    >ref - This is the flwRef returned in the charge response
    
    returns `JSONObject`
    
 
 
#### Sample

```java
Refund rf=new Refund();
<<<<<<< HEAD
rf.ref="FLW-MOCK-d310263f5f73e51d01e6dab32c893679";
System.out.println(rf.refund());
=======
System.out.println(rf.refund("FLW-MOCK-d310263f5f73e51d01e6dab32c893679"));
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
```

