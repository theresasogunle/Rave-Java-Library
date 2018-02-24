# Rave-Java-Library
Rave-Java-Library facilites quick and easy development and integration of Java based applications with the Flutterwave API. It also implements several methods for rapid prototyping and testing.

# Getting Started
## Installation
- Download Rave-Java-Library
- Install RaveJava.jar,You can find it in the lib folder of this project. On Netbeans IDE: Project properties -> Libraries -> Compile -> ADD JAR/folder -> Add Jar
- The other needed dependencies are contained in the lib folder in the Rave-Java-Library project, On Netbeans IDE: Project properties -> Libraries -> Compile -> ADD JAR/folder -> Add Jar
# NOTE
RaveJava uses a env.json file for the management of api key resources. 
This file must be placed in your root project directory and has the following structure:
```
{
    "API_KEYS": {
   "SECRET_KEY": "FLWSECK-YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY-X",
   "PUBLIC_KEY": "FLWPUBK-YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY-X"  }
}


```
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