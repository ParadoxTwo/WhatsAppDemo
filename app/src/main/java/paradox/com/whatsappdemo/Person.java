package paradox.com.whatsappdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by winbr on 6/19/2017.
 */

public class Person {
    private String name;
    private String content="";
    private String date;
    private Boolean call=false;
    private String msg="";

    // Constructor
    public Person(String n, String c,String m, String d){
        this.name = n;
        this.content = c;
        this.msg = m;
        this.date = d;
    }
    public Person(String n, String c, String d){
        this.name = n;
        this.content = c;
        this.date = d;
    }
    public Person(String n, String c, Boolean cl, String d){
        this.name = n;
        this.content = c;
        this.call = cl;
        this.date = d;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public Boolean getCall() { return call; }

    public String getMsg() {
        return msg;
    }
}