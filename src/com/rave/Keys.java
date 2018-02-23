package com.rave;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.JSONObject;



/**
 * @author Theresa
 */
class Keys {

    public String SECRET_KEY;
    public String PUBLIC_KEY;
  
    

    /**
     * Used to initialise all necessary API keys
     *
     * @throws FileNotFoundException
     */
    void initializeKeys() throws FileNotFoundException {
        JSONObject keyObject;
        String fileContent = "";
        File file = new File("Keys.json");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            fileContent += scanner.nextLine();
        }
        try{
        keyObject = new JSONObject(fileContent).getJSONObject("API_KEYS");
       
        this.SECRET_KEY = keyObject.getString("SECRET_KEY");
        this.PUBLIC_KEY = keyObject.getString("PUBLIC_KEY");
       
        }catch(Exception e){System.out.println("Cant get keys");}
    }

    /**
     * Used to set  secret key
     *
     * @param key
     */
    protected void setSECRET_KEY(String key) {
        this.SECRET_KEY = key;
    }

    /**
     * Used to get secret key
     *
     * @return
     */
    protected String getSECRET_KEY() {
        return this.SECRET_KEY;
    }

    /**
     * Used to set public key
     *
     * @param key
     */
    protected void setPUBLIC_KEY(String key) {
        this.PUBLIC_KEY = key;
    }

    /**
     * Used to get  public key
     *
     * @return
     */
    protected String getPUBLIC_KEY() {
        return this.PUBLIC_KEY;
    }

    
}
    
