package com.github.theresasogunle;

import java.util.HashMap;


public class ApiQuery {

   final private HashMap<String, Object> queryMap;

    /**
     * Initializes a new query map
     */
    public ApiQuery() {
        this.queryMap = new HashMap<>();
    }

    /**
     * Used to add a parameter to the query map
     *
     * @param key
     * @param value
     */
    public void putParams(String key, Object value) {
        this.queryMap.put(key, value);
    }

    
    public HashMap<String, Object> getParams() {
        return this.queryMap;
    }

}
