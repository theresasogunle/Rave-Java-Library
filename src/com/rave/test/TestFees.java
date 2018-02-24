/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.Fees;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class TestFees {
    public static void main(String[] args){

        Fees fee=new Fees();
        fee.amount="500";
        fee.card6="673900";
        fee.currency="NGN";
        
        //System.out.println(fee.getFees());
        //System.out.println(fee.getFeesForCard6());

    }
}
