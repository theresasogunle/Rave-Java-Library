/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import com.mashape.unirest.http.JsonNode;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class Bank {
    private ApiConnection apiConnection;
    Endpoints ed= new Endpoints();
    
    public JsonNode getAllBanks(){
        this.apiConnection = new ApiConnection(ed.getBankEndPoint());
        
        return this.apiConnection.connectAndQueryWithGet();
    }
    
}
