/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ravejava;

import com.mashape.unirest.http.JsonNode;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class Bank {
    private ApiConnection apiConnection;
    
    public JsonNode getAllBanks(){   
     this.apiConnection = new ApiConnection(Endpoints.BANK_ENDPOINT);
       
     
        return this.apiConnection.connectAndQueryWithGet();
    
   
    }
    
}
