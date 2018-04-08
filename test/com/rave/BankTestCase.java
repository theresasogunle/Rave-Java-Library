/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import com.mashape.unirest.http.JsonNode;
import org.json.JSONException;

import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class BankTestCase {
    @Test
    public void testBank()throws JSONException{
    
    Bank b=new Bank();
    JsonNode result=b.getAllBanks();

   // System.out.println(response);
    
    }
}
