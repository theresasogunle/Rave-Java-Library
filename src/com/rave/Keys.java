package com.rave;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.JSONObject;



/**
 * @author Theresa
 */
public class Keys {

    public String SECRET_KEY;
    public String PUBLIC_KEY;
    public String env;
  
    

    /**
     * Used to initialise all necessary API keys
     *
     * @throws FileNotFoundException
     */
      public  void initializeKeys() throws FileNotFoundException {
        JSONObject keyObject;
        String fileContent = "";
        File file = new File("env.json");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            fileContent += scanner.nextLine();
        }
        try{
        keyObject = new JSONObject(fileContent).getJSONObject("API_KEYS");
      
        this.env= keyObject.getString("ENV");
        this.SECRET_KEY = keyObject.getString("SECRET_KEY");
        this.PUBLIC_KEY = keyObject.getString("PUBLIC_KEY");
       
        }catch(Exception e){System.out.println("Cant get keys");}
    }


    
         public String getPublicKey(){
        Keys key= new Keys();

               try {
                   key.initializeKeys();
               } catch (FileNotFoundException e) {
                   System.out.print("Required Keys.json file could not be found.");
                   e.printStackTrace();
               }
               String public_key=key.PUBLIC_KEY;
                 
               return public_key;
        
        }
     public String getSecretKey(){
        Keys key= new Keys();

               try {
                   key.initializeKeys();
               } catch (FileNotFoundException e) {
                   System.out.print("Required Keys.json file could not be found.");
                   e.printStackTrace();
               }
               String secret_key=key.SECRET_KEY;
               //  System.out.println(public_key);
                 
                 return secret_key;
        
        }
    protected void setEnvironment(String env){
    this.env=env;
    }
    protected String getEnvironment() {
        Keys key= new Keys();
         try {
            key.initializeKeys();
        } catch (FileNotFoundException e) {
            System.out.print("Required Keys.json file could not be found.");
            e.printStackTrace();
        }
            String envv=key.env;
        return envv;
    }
    
    

    
}
    
