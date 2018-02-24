## ExchangeRates

### Class Name - ExchangeRates

<<<<<<< HEAD
#### Fields
    >origin_currency - This is the currency to convert from
    >destination_currency - This is the currency to convert from
    >amount - This is the currency to convert to

#### Methods
1. forex()
=======
#### Methods
1. forex(String origin_currency, String destination_currency, String amount)
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4

    This endpoint provides a list of banks that can be charged on rave. It returns a key/value pair internetbanking in the response, if set to false it means the account can be charged using the direct account method, if set to true it means the account would be charged using the internet banking flow
    
    >origin_currency - This is the currency to convert from
    >destination_currency - This is the currency to convert from
    >amount - This is the currency to convert to

    returns `JsonNode`
 
#### Sample

```java
ExchangeRates e=new ExchangeRates();
<<<<<<< HEAD
e.origin_currency="NGN";
e.destination_currency="USD";
e.amount="500";
System.out.println(e.forex());
=======
System.out.println(e.forex("NGN", "USD", "300"));
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
```

