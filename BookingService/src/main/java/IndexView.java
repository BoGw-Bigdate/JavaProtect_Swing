import javax.swing.*;
import java.awt.*;

/*
* 主界面
* */
public class IndexView extends JPanel {
    JTabbedPane p;
    RegisterView registerView;
    LoginView loginView;

    public IndexView() {
        registerView=new RegisterView();
        loginView=new LoginView();
        p=new JTabbedPane();
        p.add("注册",registerView);
        p.add("登录",loginView);
        p.validate();
        add(p, BorderLayout.CENTER);
    }
    public boolean IntoBook() {
        return loginView.LoginSuccess();
    }
    public String getID(){
        return loginView.getID();
    }
}
