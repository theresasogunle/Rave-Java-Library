package ravejava;



/**
 * @author Theresa
 */
class Keys {

    protected String SECRET_KEY;
    protected String PUBLIC_KEY;
   
  
    void initializeKeys(){
        SECRET_KEY = "FLWSECK-YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY-X";
        PUBLIC_KEY = "FLWPUBK-YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY-X";
       
    }
    

    
    /**
     * Used to set test secret key
     *
     * @param key
     */
    protected void setSECRET_KEY(String key) {
        this.SECRET_KEY = key;
    }

    /**
     * Used to get test secret key
     *
     * @return
     */
    protected String getSECRET_KEY() {
        return this.SECRET_KEY;
    }

    /**
     * Used to set test public key
     *
     * @param key
     */
    protected void setPUBLIC_KEY(String key) {
        this.PUBLIC_KEY = key;
    }

    /**
     * Used to get test public key
     *
     * @return
     */
    protected String getPUBLIC_KEY() {
        return this.PUBLIC_KEY;
    }

    
   

}
