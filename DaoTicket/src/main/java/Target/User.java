package Target;

public class User {
    String ID;
    String Name;
    private String Password;
    String Age;
    public User(String id, String password, String name,String age){
        ID = id;
        Name = name;
        Password=password;
        Age = age;
    }

    public User() {
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public String getAge() {
        return Age;
    }

    @Override
    public String toString() {
        String a="--------------------"+
                "\nID:"+ID+
                "\nPassword:"+Password+
                "\nName:"+Name+
                "\nAge:"+Age+
                "\n--------------------";
       return a;
    }
}
