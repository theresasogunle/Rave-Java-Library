## Fees

### Class Name - Fees

#### Methods
1. getFees(String amount,String currency)

    >currency - This is the specified currency to charge the card in.
    >amount - This is the amount of the product or service to charged from the customer

    returns `JSONObject`
    
2. getFeesForCard6(String amount,String currency, String card6)
    >currency - This is the specified currency to charge the card in.
    >amount - This is the amount of the product or service to charged from the customer
    >card6 - The first 6digits of their card number, it also helps determine international fees on the transaction if the card being used is an international card
    
    returns `JSONObject`
    
#### The successful response for get fees endpoint is broken down this way:

 `data.charge_amount:` This the total amount to be charged, total amount = amount + fee

 `data.fee:` This is a cumulative of the merchantfee (if applicable) + ravefee

 `data.merchantfee:` This is the merchant fee on the transaction, it is applicable when using a subdomain. Subdomains allow you white-label rave, and offer it as a customised service to your merchant, we allow you set a markup fee on it and earn transaction fees. In this scenario the merchant-fee would be the subdomain markup fee if applicable.

 `data.ravefee:` This is the fee charged per transaction by rave.
 
 
#### Sample

```java
Fees rf=new Fees();
System.out.println(rf.getFees("5000","NGN"));
System.out.println(rf.getFeesForCard6("5000", "NGN", "674893"));
```

