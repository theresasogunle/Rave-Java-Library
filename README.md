# Rave-Java-Library
Rave-Java-Library facilites quick and easy development and integration of Java based applications with the Flutterwave API. It also implements several methods for rapid prototyping and testing.

# Getting Started
## Installation
- Download Rave-Java-Library
- Install RaveJava.jar,You can find it in the lib folder of this project. On Netbeans IDE: Project properties -> Libraries -> Compile -> ADD JAR/folder -> Add Jar
- The other needed dependencies are contained in the lib folder in the Rave-Java-Library project, On Netbeans IDE: Project properties -> Libraries -> Compile -> ADD JAR/folder -> Add Jar
# NOTE
RaveJava uses a Keys.json file for the management of api key resources. 
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
### For Merchant
- FOR GTB display *737*50*amount*159#and return flwRef for the customer so as to complete the transaction
### For the developer
- Use webhooks to get notified on transaction, and set it to pending, then complete/failed once notified with same status on webhook. See guide on using webhooks here: https://flutterwavedevelopers.readme.io/v2.0/docs/events-webhooks
- After getting the notofication, requery to confirm final status
## Ghana Mobile Money
### For the developer
- Use webhooks to get notified on transaction, and set it to pending, then complete/failed once notified with same status on webhook.
- Webhooks? See guide on using webhooks here: https://flutterwavedevelopers.readme.io/v2.0/docs/events-webhooks
- After getting the notofication, requery to confirm final status
## Kenya Mpesa
-Display the Mpesa Buisness account number637747 and the Account number which is returned as orderRef in the charge response.

### For the developer
-Use webhooks to get notified on transaction, and set it to pending, then complete/failed once notified with same status on webhook. See guide on using webhooks here: https://flutterwavedevelopers.readme.io/v2.0/docs/events-webhooks
-After getting the notofication, requery to confirm final status

#The MIT License (MIT)
Copyright (c) 2018 Sogunle Theresa

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
