# Flutterwave Rave (Rave-Java-Library)
Rave-Java-Library facilites quick and easy development and integration of Java based applications with the Flutterwave API. It also implements several methods for rapid prototyping and testing.

- **Contributors:** **Theresa Sogunle**, Oluwole Adebiyi (KingFlamez)
- **Tags:** rave, flutterwave, payment gateway, bank account, credit card, debit card, nigeria, kenya, ghana, international, mastercard, visa, KES, GHC, NGN,  Java.

# Getting Started

## Prerequisite
> Signup for a test account [here](http://rave.frontendpwc.com/)
> Signup for a live account [here](https://rave.flutterwave.com)

## Installation
- Download Rave-Java-Library
- Install [rave-java-1.0.jar](lib/rave-java-1.0.jar?raw=true), Located in the lib folder of this project. 
- Install the other needed library dependencies which are also contained in the [`Lib folder`](lib) in the [`Rave-Java-Library project`](lib)

### How to Install Libraries
>On Netbeans IDE: `Project properties -> Libraries -> Compile -> ADD JAR/folder -> Add Jar`

>On Intelli J IDEA: `File > Project Structure -> Project Settings > Modules > Dependencies > "+" sign > JARs or directories`

- Add a file to your root folder as `env.json` which will contain your `public key`, `secret key` and `environment`

```json
{
    "API_KEYS": {
      "ENV": "LIVE",
      "PUBLIC_KEY": "FLWPUBK-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-X",
      "SECRET_KEY": "FLWSECK-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-X"
    }
}
```

- `ENV` - Either `LIVE` or `TESTING`
- `PUBLIC_KEY` - Gotten From Your Rave Dashboard
- `SECRET_KEY` - Gotten From Your Rave Dashboard

- Set to go 💪


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

- Rave Card Charge
```java
import com.rave.Encryption;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args)throws JSONException {
	CardCharge ch=new CardCharge();
       ch.setCardno("4187427415564246");
       ch.setCvv("828");
       ch.setCurrency("NGN");
       ch.setCountry("NG");
       ch.setAmount("9000");
       ch.setExpiryyear("19");
       ch.setExpirymonth("09");
       ch.setEmail("sogunledolapo@gmail.com");
       ch.setIP("103.238.105.185");
       ch.setTxRef("MXX-ASC-4578");
       ch.setDevice_fingerprint("69e6b7f0sb72037aa8428b70fbe03986c");
     
         //for master card and verve
       ch.setPin("3310");
       ch.setSuggested_auth("PIN");
       JSONObject charge= ch.chargeMasterAndVerveCard();
       
       //for visa and intl cards
        ch.setRedirect_url("http://www.google.com");
        JSONObject chargevisa=ch.chargeVisaAndIntl();
       
    }
}
```

- Rave Account Charge
```java
import com.rave.AccountCharge;
import com.rave.Encryption;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws JSONException{
      	   
	    JSONObject json= new JSONObject();
            AccountCharge ch= new AccountCharge();
            
            ch.setAccountnumber("0690000031");
            ch.setAccountbank("044");
            ch.setAmount("1000");
            ch.setCountry("NG");
            ch.setCurrency("NGN");
            ch.setLastname("Theresa");
            ch.setIP("1.3.4.4");
            ch.setPayment_type("account");
            ch.setTxRef("MX-678DH");
            ch.setEmail("sogunledolapo@gmail.com");

	      JSONObject result=ch.chargeAccount();
          
        System.out.println(result);
        //Validate The Charge
         //do not forget to set your fields
        ch.setTransaction_reference("ACHG-1520028650995");
        ch.setOtp("12345");
        JSONObject val=ch.validateAccountCharge();
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
11. [IntegrityChecksum](Documentation/CHECKSUM.md)
12. [Polling](For timeouts)

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
