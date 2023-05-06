package hcmute.edu.vn.cuik;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Login implements Serializable {
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("access_token")
    @Expose
    private String access_token;

    @SerializedName("id")
    @Expose
    private int id;

    public Login(String message, String access_token, int id) {
        this.message = message;
        this.access_token = access_token;
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
