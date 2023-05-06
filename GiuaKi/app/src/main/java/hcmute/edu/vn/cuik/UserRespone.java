package hcmute.edu.vn.cuik;

public class UserRespone {
    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRespone(boolean error, String message, User user) {
        this.error = error;
        this.message = message;
        this.user = user;
    }

    boolean error;
    String message;
    User user;
}