
/*
* 登录账号
* */
public class Login {
    String ID;
    private String Password;
    boolean Success=false;

    public Login(String ID, String password) {
        this.ID = ID;
        Password = password;
    }

    public Login() {
    }
    public String getID() {
        return ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    @Override
    public String toString() {
        return "Login{" +
                "ID='" + ID + '\'' +
                ", Password='" + Password + '\'' +
                ", Success=" + Success +
                '}';
    }
}
