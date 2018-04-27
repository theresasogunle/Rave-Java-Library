/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.theresasogunle;


import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class Refund {
    private ApiConnection apiConnection;
    final  private RaveConstant key= new RaveConstant();
    Endpoints end= new Endpoints();
   private String ref;
    /**
     * @return JSONObject
     *
     */
    public JSONObject refund(){
        this.apiConnection = new ApiConnection(end.getRefundEndPoint());
        ApiQuery api= new ApiQuery();

        api.putParams("ref", this.getRef());
        api.putParams("seckey",  RaveConstant.SECRET_KEY);


        return this.apiConnection.connectAndQuery(api);
    }

    /**
     * @return the ref
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref the ref to set
     */
    public void setRef(String ref) {
        this.ref = ref;
    }
}
