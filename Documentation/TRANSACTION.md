## Transaction

### Class Name - Transaction
<<<<<<< HEAD
#### Fields
>flw_ref - This is the `flwRef` returned in the `charge response`
>txref
#### Methods
1. verifyTransactionRequery()
=======

#### Methods
1. verifyTransactionRequery(String flw_ref)
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4

    This method allows you to verify transactions
    
    **Parameters**
    
    >flw_ref - This is the `flwRef` returned in the `charge response`
    
    returns `JSONObject`
    
<<<<<<< HEAD
 2. verifyTransactionXquery()
=======
 2. verifyTransactionXquery(String txref, String flwref)
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
 
    This method allows you to verify transactions using your own transaction reference or the flwref
 
#### Sample

```java
  Transaction t=new Transaction();
<<<<<<< HEAD
  t.flw_ref="FLW-MOCK-d310263f5f73e51d01e6dab32c893679";
  JSONObject tt= t.verifyTransactionRequery();
=======
  JSONObject tt= t.verifyTransactionRequery("FLW-MOCK-d310263f5f73e51d01e6dab32c893679");
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
  System.out.println(tt);
```

