[![Coverage Status](https://coveralls.io/repos/github/theresasogunle/Rave-Java-Library/badge.svg)](https://coveralls.io/github/theresasogunle/Rave-Java-Library)
[![Maintainability](https://api.codeclimate.com/v1/badges/540ffe707c495f483166/maintainability)](https://codeclimate.com/github/theresasogunle/Rave-Java-Library/maintainability)
[![Build Status](https://scrutinizer-ci.com/g/theresasogunle/Rave-Java-Library/badges/build.png?b=master)](https://scrutinizer-ci.com/g/theresasogunle/Rave-Java-Library/build-status/master)
[![Scrutinizer Code Quality](https://scrutinizer-ci.com/g/theresasogunle/Rave-Java-Library/badges/quality-score.png?b=master)](https://scrutinizer-ci.com/g/theresasogunle/Rave-Java-Library/?branch=master)
# Flutterwave Rave (Rave-Java-Library)
Rave-Java-Library facilitates quick and easy development and integration of Java based applications with the Flutterwave API.
- **Contributors:** **Theresa Sogunle**, Oluwole Adebiyi (KingFlamez)
- **Tags:** rave, flutterwave, payment gateway, bank account, credit card, debit card, nigeria, kenya, ghana, international, mastercard, visa, KES, GHC, NGN,  Java.

# Getting Started

## Prerequisite
> Signup for a test account [here](http://rave.frontendpwc.com/)

> Signup for a live account [here](https://rave.flutterwave.com)

## Installation (Jar file)

- Download latest Rave-Java-Library jar file from the [releases tab](https://github.com/theresasogunle/Rave-Java-Library/releases)
- Install it and the other needed library dependencies which are contained in the `lib.zip` in the [releases tab](https://github.com/theresasogunle/Rave-Java-Library/releases)

### How to Install Libraries
>On Netbeans IDE: `Project properties -> Libraries -> Compile -> ADD JAR/folder -> Add Jar`

>On Intelli J IDEA: `File > Project Structure -> Project Settings > Modules > Dependencies > "+" sign > JARs or directories`

>On Android Studio: Add the rave to your libs folder, right click on it and add as a library

- Set to go 💪

## Sample Use

- Getting the list of banks from Flutterwave

```java
import com.rave.Bank;

public class Main {

    public static void main(String[] args) {
	//rave constants
        RaveConstant.ENVIRONMENT=Environment.STAGING; //or live

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
	//rave constants
        RaveConstant.PUBLIC_KEY="FLWPUBK-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-X";
        RaveConstant.SECRET_KEY="FLWSECK-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-X";
        RaveConstant.ENVIRONMENT=Environment.STAGING; //or live

	CardCharge ch=new CardCharge();
        ch.setCardno("4187427415564246")
          .setCvv("828")
          .setCurrency("NGN")
          .setCountry("NG")
          .setAmount("9000")
          .setExpiryyear("19")
          .setExpirymonth("09")
          .setEmail("sogunledolapo@gmail.com")
          .setIP("103.238.105.185")
          .setTxRef("MXX-ASC-4578")
          .setDevice_fingerprint("69e6b7f0sb72037aa8428b70fbe03986c");
     
         //for master card and verve
     
           ch.setPin("3310")
             .setSuggested_auth("PIN");
             JSONObject charge= ch.chargeMasterAndVerveCard();
            //if timeout
            JSONObject poll=ch.chargeMasterAndVerveCard(true);
   
       
       //for visa and intl cards
        ch.setRedirect_url("http://www.google.com");
        JSONObject chargevisa=ch.chargeVisaAndIntl();
	  //if timeout, poll
            JSONObject pollvisa=ch.chargeVisaAndIntl(true);
       
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
      	   //rave constants
        RaveConstant.PUBLIC_KEY="FLWPUBK-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-X";
        RaveConstant.SECRET_KEY="FLWSECK-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-X";
        RaveConstant.ENVIRONMENT=Environment.STAGING; //or live

	  
            AccountCharge ch= new AccountCharge();
            
          ch.setAccountnumber("0690000031")
            .setAccountbank("044")
            .setAmount("1000")
            .setCountry("NG")
            .setCurrency("NGN")
            .setLastname("Theresa")
            .setIP("1.3.4.4")
            .setPayment_type("account")
            .setTxRef("MX-678DH")
            .setEmail("sogunledolapo@gmail.com");
          
         JSONObject result=ch.chargeAccount();
          //polling
            JSONObject poll=ch.chargeAccount(true);
        System.out.println(result);
        //Validate The Charge
         //do not forget to set your fields
        ch.setTransaction_reference("ACHG-1520028650995")
          .setOtp("12345");
        //for polling
        JSONObject val=ch.validateAccountCharge(true);
        //without polling
        JSONObject validate=ch.validateAccountCharge());
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


## Todo

- Recurring Payments

## License

The MIT License (MIT). Please see [License File](LICENSE.md) for more information.
