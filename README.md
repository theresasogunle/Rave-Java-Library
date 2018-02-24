# Flutterwave Rave (Rave-Java-Library)
Rave-Java-Library facilites quick and easy development and integration of Java based applications with the Flutterwave API. It also implements several methods for rapid prototyping and testing.

- **Contributors:** **Theresa Sogunle**, Oluwole Adebiyi (KingFlamez)
- **Tags:** rave, flutterwave, payment gateway, bank account, credit card, debit card, nigeria, kenya, ghana, international, mastercard, visa, KES, GHC, NGN,  Java.

# Getting Started
## Installation
- Download Rave-Java-Library
- Install RaveJava.jar, Located in the lib folder of this project. 
>On Netbeans IDE: `Project properties -> Libraries -> Compile -> ADD JAR/folder -> Add Jar`

>On Intelli J IDEA: `File > Project Structure -> Project Settings > Modules > Dependencies > "+" sign > JARs or directories`

- The other needed dependencies are contained in the Lib folder in the Rave-Java-Library project

- Add a file to your root folder as env.json which will contain your public key, secret key and environment

```json
{
    "API_KEYS": {
      "ENV": "LIVE",
      "PUBLIC_KEY": "FLWPUBK-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-X",
      "SECRET_KEY": "FLWSECK-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-X"
    }
}
```

- `ENV_KEY` - Either `LIVE` or `TESTING`
- `PUBLIC_KEY` - Gotten From Your Rave Dashboard
- `SECRET_KEY` - Gotten From Your Rave Dashboard

- Set to go 💪


> You can signup for an account [here](https://rave.flutterwave.com)


## Sample Use

- Getting the list of banks from Flutterwave

```java
import com.rave.Bank;

public class Main {

    public static void main(String[] args) {
        // Create a bank Object
        Bank B = new Bank();
        // Print all banks with getAllBanks() method
        System.out.println(B.getAllBanks());
    }
}
```

- Rave Encryption
```java
import com.rave.Encryption;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        // Create a JSONObject Object to store your parameters
        JSONObject api=new JSONObject();
        
        // Instantiate the Encryption Class
        Encryption encryption=new Encryption();

        //Put in the parameters according to the documentation
        try{
            api.put("accountnumber", "0690000004");
            api.put("accountbank", "044");
            api.put("currency", "NGN");
            api.put("country", "NG");
            api.put("amount", "6000");
            api.put("firstname", "pin");
            api.put("lastname", "pin");
            api.put("pin", "3310");
            api.put("email", "flamekeed@gmail.com");
            api.put("IP", "103.238.105.185");
            api.put("txRef", "MXX-ASC-4578");
            api.put("payment_type", "account");

        }catch(Exception ex){}
        
        //Pass the object and encrypt with the encryptParameters(api) method
        String encrypted_message= encryption.encryptParameters(api);
        
        System.out.println(encrypted_message);
    }
}
```

- Rave Account Charge
```java
import com.rave.AccountCharge;
import com.rave.Encryption;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        //Encryption first
        
        // Create a JSONObject Object to store your parameters
        JSONObject api = new JSONObject();
        // Instantiate the Encryption Class
        Encryption encryption = new Encryption();
        // Instantiate the AccountCharge Class
        AccountCharge ch = new AccountCharge();

        //Put in the parameters according to the documentation
        try{
            api.put("accountnumber", "0690000004");
            api.put("accountbank", "044");
            api.put("currency", "NGN");
            api.put("country", "NG");
            api.put("amount", "6000");
            api.put("firstname", "pin");
            api.put("lastname", "pin");
            api.put("pin", "3310");
            api.put("email", "sogunledolapo@gmail.com");
            api.put("IP", "103.238.105.185");
            api.put("txRef", "MXX-ASC-4578");
            api.put("payment_type", "account");

        }catch(Exception ex){}
        
        //Encrypt Parameters
        String encrypted_message= encryption.encryptParameters(api);

        //Charge Account
        JSONObject res=ch.chargeAccount(encrypted_message);
        
        System.out.println(res);
        //Validate The Charge
        // ch.
        //JSONObject val=ch.validateAccountCharge("ACHG-1519428047882", "12345");
    }
}

```

## Classes and Methods

The documentation for each classes and methods

1. [AccountCharge](Documentation/ACCOUNT.md)
2. [AlternatePayment](Documentation/ALTPAYMENT.md)
3. [Bank](Documentation/BANK.md)
4. [CardCharge](Documentation/CARD.md)
5. [Encryption](Documentation/ENCRYPTION.md)
6. [ExchangeRates](Documentation/EXCHANGERATES.md)
7. [Fees](Documentation/FEES.md)
8. [PreAuthorization](Documentation/PREAUTH.md)
9. [Refund](Documentation/REFUND.md)
10. [Transaction](Documentation/REFUND.md)

# Alternative Payment Methods
## Nigerian USSD- GTB and Zenith Bank
#### For Merchant
- FOR GTB display ```*737*50*amount*159#```and return flwRef for the customer so as to complete the transaction
#### For the developer
- Use webhooks to get notified on transaction, and set it to pending, then complete/failed once notified with same status on webhook. - - Webhooks? See guide on using webhooks here: https://flutterwavedevelopers.readme.io/v2.0/docs/events-webhooks
- After getting the notofication, requery to confirm final status
## Ghana Mobile Money
#### For the developer
- Use webhooks to get notified on transaction, and set it to pending, then complete/failed once notified with same status on webhook.
- Webhooks? See guide on using webhooks here: https://flutterwavedevelopers.readme.io/v2.0/docs/events-webhooks
- After getting the notofication, requery to confirm final status
## Kenya Mpesa
-Display the Mpesa Buisness account number ```637747``` and the Account number which is returned as orderRef in the charge response.
#### For the developer
- Use webhooks to get notified on transaction, and set it to pending, then complete/failed once notified with same status on webhook. - - Webhooks? See guide on using webhooks here: https://flutterwavedevelopers.readme.io/v2.0/docs/events-webhooks
-After getting the notofication, requery to confirm final status

## Todo

- Recurring Payments

## License

The MIT License (MIT). Please see [License File](LICENSE.md) for more information.
