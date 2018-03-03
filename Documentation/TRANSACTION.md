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
    

 2. verifyTransactionXrequery()

    This method allows you to verify transactions using your own transaction reference or the flwref
 
#### Sample

```java
  Transaction t=new Transaction();

        t.setFlwref("FLW-MOCK-d310263f5f73e51d01e6dab32c893679")
          .setTxRef("");
        JSONObject response=  t.verifyTransactionRequery();
	JSONObject tt= t.verifyTransactionXrequery();

     System.out.println(tt);
```

