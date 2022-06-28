import com.sun.xml.internal.ws.developer.Serialization;

import java.io.*;

public class Friend implements Serializable {


    String friendName;
    String contact;
    String address;



    Friend( String friendName, String contact, String address){
        this.friendName = friendName;
        this.contact = contact;
        this.address = address;
    }

    public  String toString(){
        return    friendName + " " + contact + " " + address;
    }


}
