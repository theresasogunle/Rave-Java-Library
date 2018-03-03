
package com.rave;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.FileNotFoundException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import static org.apache.http.conn.ssl.SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;



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
     this.enforceTlsV1point2();
    }
     private void enforceTlsV1point2() {
        try {
            SSLContext sslContext = SSLContexts.custom()
                    .useTLS()
                    .build();
            SSLConnectionSocketFactory f = new SSLConnectionSocketFactory(
                    sslContext,
                    new String[]{"TLSv1.2"},
                    null,
                    BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            CloseableHttpClient httpClient = HttpClients.custom()
                    .setSSLSocketFactory(f)
                    .build();
            Unirest.setHttpClient(httpClient);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ApiConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(ApiConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                    
                    .asJson();
            
            return queryForResponse.getBody();
           
        } catch (UnirestException e) {
            System.out.println("Cant query at this time!");
        }
        return null;
    }
     public JSONObject connectAndQueryWithGetObj() {
        try {
            HttpResponse<JsonNode> queryForResponse = Unirest.get(url)
                    .header("content-type", "application/json")
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
