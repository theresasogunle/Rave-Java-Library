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
        RaveConstant.PUBLIC_KEY="FLWPUBK-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-X";
        RaveConstant.SECRET_KEY="FLWSECK-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-X";
        RaveConstant.ENVIRONMENT=Environment.STAGING; //or live
Refund rf=new Refund();

 rf.setRef("FLW-MOCK-dcd2cd407f37649b04eb1342247e0bf6");
        
System.out.println(rf.refund());

```

