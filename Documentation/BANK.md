## Bank

### Class Name - Bank

#### Methods
1. getAllBanks()

    This method provides a list of banks that can be charged on rave. It returns a key/value pair internetbanking in the response, if set to false it means the account can be charged using the direct account method, if set to true it means the account would be charged using the internet banking flow

    returns `JsonNode`
 
#### Sample

```java
Bank b= new Bank();
System.out.println(b.getAllBanks());
```

