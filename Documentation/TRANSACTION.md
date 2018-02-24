## Transaction

### Class Name - Transaction

#### Methods
1. verifyTransactionRequery(String flw_ref)

    This method allows you to verify transactions
    
    **Parameters**
    
    >flw_ref - This is the `flwRef` returned in the `charge response`
    
    returns `JSONObject`
    
 2. verifyTransactionXquery(String txref, String flwref)
 
    This method allows you to verify transactions using your own transaction reference or the flwref
 
#### Sample

```java
  Transaction t=new Transaction();
  JSONObject tt= t.verifyTransactionRequery("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
  System.out.println(tt);
```

