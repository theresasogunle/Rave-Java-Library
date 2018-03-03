package com.rave;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;



/**
 * @author Theresa
 */
public class ApiConnection {

    private String url;
  

    /**
     * @param url - Flutterwave API url
     */
    public ApiConnection(String url) {
       this.url = url;
     
    }

     
    /**
     * Connects to and queries Flutterwave API with POST
     *
     * @param query - APIQuery containing parameters to send
     * @return - JSONObject containing API response
     */
    public JSONObject connectAndQuery(ApiQuery query) {
        try {
            HttpResponse<JsonNode> queryForResponse = Unirest.post(url)
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer ")
                    .fields(query.getParams())
                    .asJson();
            
           
            
            try{
            return queryForResponse.getBody().getObject();
            }catch(Exception ex){}
        } catch (UnirestException e) {
            e.printStackTrace();
        
    
      
    
    }
         return  null;
    }
    /**
     * Connects to and queries API with POST
     *
     * @param query - HashMap containing parameters to send
     * @return - JSONObject containing API response
     */
    public JSONObject connectAndQuery(HashMap<String, Object> query) {
        try {
            HttpResponse<JsonNode> queryForResponse = Unirest.post(url)
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer ")
                    .fields(query)
                    .asJson();
            return queryForResponse.getBody().getObject();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Used to send a GET request to the Flutterwave API
     *
     * @return - JSONObject containing the API response
     */
    public JsonNode connectAndQueryWithGet() {
        try {
            HttpResponse<JsonNode> queryForResponse = Unirest.get(url)
                    .header("content-type", "application/json")
                    .header("Authorization", "Bearer ")
                    .asJson();
            
            return queryForResponse.getBody();
           
        } catch (UnirestException e) {
            System.out.println("Cant query at this time!");e.printStackTrace();
        }
        return null;
    }
     public JSONObject connectAndQueryWithGetObj() {
        try {
            HttpResponse<JsonNode> queryForResponse = Unirest.get(url)
                    .header("content-type", "application/json")
                    .header("Authorization", "Bearer ")
                    .asJson();
            
            return queryForResponse.getBody().getObject();
           
        } catch (UnirestException e) {
            System.out.println("Cant query at this time!");e.printStackTrace();
        }
        return null;
    }
  public JsonNode connectAndQueryWithPost() {
        try {
            HttpResponse<JsonNode> queryForResponse = Unirest.post(url)
                    .header("content-type", "application/json")
                    .header("Authorization", "Bearer " )
                    .asJson();
            
            return queryForResponse.getBody();
           
        } catch (UnirestException e) {
            System.out.println("Cant query at this time!");e.printStackTrace();
        }
        return null;
    }

    /**
     * Used to send a GET request to the Flutterwave API
     *
     * @param query - APIQuery containing parameters to send
     * @return - JSONObject containing API response
     */
    public JSONObject connectAndQueryWithGet(ApiQuery query) {
        try {
            HttpResponse<JsonNode> queryForResponse = Unirest.get(url)
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer " )
                    .queryString(query.getParams())
                    .asJson();
            return queryForResponse.getBody().getObject();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Used to send a GET request to the Flutterwave API
     *
     * @param query - HashMap containing parameters to send
     * @return - JSONObject containing API response
     */
    public JSONObject connectAndQueryWithGet(HashMap<String, Object> query) {
        try {
            HttpResponse<JsonNode> queryForResponse = Unirest.get(url)
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer " )
                    .queryString(query)
                    .asJson();
            return queryForResponse.getBody().getObject();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Used to send a PUT request to the Flutterwave API
     *
     * @param query - APIQuery containing parameters to send
     * @return - JSONObject containing API response
     */
    public JSONObject connectAndQueryWithPut(ApiQuery query) {
        try {
            HttpResponse<JsonNode> queryForResponse = Unirest.put(url)
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer " )
                    .fields(query.getParams())
                    .asJson();
            return queryForResponse.getBody().getObject();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Used to send a PUT request to the Flutterwave API
     *
     * @param query - HashMap containing parameters to send
     * @return - JSONObject containing API response
     */
    public JSONObject connectAndQueryWithPut(HashMap<String, Object> query) {
        try {
            HttpResponse<JsonNode> queryForResponse = Unirest.get(url)
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer " )
                    .queryString(query)
                    .asJson();
            return queryForResponse.getBody().getObject();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * shut down the apiConnection
     */
    public static void shutDown() {
        try {
            Unirest.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
