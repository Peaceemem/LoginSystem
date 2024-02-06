import java.util.HashMap;

public class IDandPassword {
    //Hashmap
    HashMap<String,String> logininfo = new HashMap<String,String>();
    // create a conStruCtor for our ID and Password class
    IDandPassword(){
        logininfo.put("Peace", "sweet");
        logininfo.put("vera", "PASSWORD");
        logininfo.put("dad", "abc123");
    }
   protected HashMap getLoginInfo(){
        return logininfo;
    }
}
