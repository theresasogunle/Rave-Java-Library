## ExchangeRates

### Class Name - ExchangeRates

#### Fields
>origin_currency - This is the currency to convert from

>destination_currency - This is the currency to convert from

>amount - This is the currency to convert to

#### Method
1. forex()

    This endpoint provides a list of banks that can be charged on rave. It returns a key/value pair internetbanking in the response, if set to false it means the account can be charged using the direct account method, if set to true it means the account would be charged using the internet banking flow
    
    >origin_currency - This is the currency to convert from
    >destination_currency - This is the currency to convert from
    >amount - This is the currency to convert to

    returns `JsonNode`
 
#### Sample

```java
ExchangeRates e=new ExchangeRates();
        e.setAmount("500")
         .setDestination_currency("USD")
         .setOrigin_currency("NGN");
System.out.println(e.forex());


```

