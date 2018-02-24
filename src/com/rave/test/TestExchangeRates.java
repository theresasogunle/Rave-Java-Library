/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.ApiQuery;
import com.rave.ExchangeRates;

/**
 *
 * @author Theresa
 */
public class TestExchangeRates {
    public static void main(String [] args){
<<<<<<< HEAD
      
        ExchangeRates e=new ExchangeRates();
        e.amount="500";
        e.destination_currency="USD";
        e.origin_currency="NGN";
        System.out.println( e.forex());
=======
        ExchangeRates e=new ExchangeRates();
        System.out.println(e.forex("NGN", "USD", "300"));
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
    
    }
}
