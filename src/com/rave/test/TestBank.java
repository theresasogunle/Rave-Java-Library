/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.Bank;
import com.rave.Endpoints;
import org.json.JSONException;

/**
 *
 * @author Theresa
 */
public class TestBank {
    public static void main(String [] args) throws JSONException{
        Endpoints ed=new Endpoints();
        Bank b= new Bank();
       System.out.println(b.getAllBanks());
         
       
    }
}
