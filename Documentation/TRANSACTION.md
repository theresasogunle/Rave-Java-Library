## Transaction

### Class Name - Transaction
#### Fields
>flw_ref - This is the `flwRef` returned in the `charge response`
>txref
#### Methods
1. verifyTransactionRequery()

    This method allows you to verify transactions
    
    **Parameters**
    
    >flw_ref - This is the `flwRef` returned in the `charge response`
    
    returns `JSONObject`
    
 2. verifyTransactionXquery()
 
    This method allows you to verify transactions using your own transaction reference or the flwref
 
#### Sample

```java
  Transaction t=new Transaction();
  t.flw_ref="FLW-MOCK-d310263f5f73e51d01e6dab32c893679";
  JSONObject tt= t.verifyTransactionRequery();
  System.out.println(tt);
```

