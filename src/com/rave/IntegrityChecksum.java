/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import java.util.HashMap;

/**
 *
 * @author Theresa
 */
public class IntegrityChecksum {
      
        Keys key=new Keys();
    public String integrityChecksum(HashMap payload){
    
     payload.put("PBFPubKey", key.getPublicKey());
    
     
      Object[] keys=payload.keySet().toArray();
      Arrays.sort(keys);
       String hashedPayload = "";
       String hashString="";

    for(int i=0;i<keys.length;i++){
         Object key= keys[i];
         hashedPayload+=payload.get(key);
    }
       hashString  = hashedPayload + key.getSecretKey();
       String hash_string="";

try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[]  hash = digest.digest(hashString.getBytes(StandardCharsets.UTF_8));
        hash_string=Base64.getEncoder().encodeToString(hash);
      //  System.out.println(hash_string);
    }catch(Exception ex){}

    return hash_string;
    }
    
  
}
