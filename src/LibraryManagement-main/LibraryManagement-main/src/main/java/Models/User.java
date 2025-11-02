import Auth;

public class User  {

    private String userName;
    private String passWord;
    private Auth auth;

    @Override
    public String toString() {
        return "User" +
                "User Name = " + userName +
                "\nPassword = " + passWord +
                "\nauth = " + auth ;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName == null) throw new IllegalArgumentException("userName cannot be null");
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        if (passWord == null) throw new IllegalArgumentException("passWord cannot be null");
        this.passWord = passWord;
    }
    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        if (auth == null) throw new IllegalArgumentException("auth cannot be null");
        this.auth = auth;
    }





}
