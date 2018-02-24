/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.Refund;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class TestRefund {
    public static void main(String[] args){
        Refund rf=new Refund();
<<<<<<< HEAD
        rf.ref="FLW-MOCK-d310263f5f73e51d01e6dab32c893679";
        System.out.println(rf.refund());
=======
        System.out.println(rf.refund("FLW-MOCK-d310263f5f73e51d01e6dab32c893679"));
>>>>>>> fedc6d2151a2f23234227b302155077bf8f274b4
    }
}
