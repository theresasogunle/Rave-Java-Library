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
        Fees rf=new Fees();
        System.out.println(rf.getFees("5000","NGN"));
        System.out.println(rf.getFeesForCard6("5000", "NGN", "674893"));
    
    }
}
