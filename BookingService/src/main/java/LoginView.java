import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* 登录界面
* */
public class LoginView extends JPanel implements ActionListener {
    boolean IntoBook;
    JTextField IntoID;
    JPasswordField Password;
    JButton Into;
    String ID;
    public LoginView() {
        IntoID =new JTextField(10);
        Password=new JPasswordField(10);
        Into=new JButton("登录");
        add(new Label("ID:"));
        add(IntoID);
        add(new Label("Password:"));
        add(Password);
        add(Into);
        Into.addActionListener(this::actionPerformed);
    }

    public boolean LoginSuccess() {//返回是否登录成功
        return IntoBook;
    }

    public String getID(){//返回登录者的ID
        return ID;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Login login = new Login(IntoID.getText(), new String(Password.getPassword()));
        LoginHandle loginHandle = new LoginHandle();
        Login one = loginHandle.LoginAction(login);
        IntoBook=one.Success;
        ID=IntoID.getText();
    }
}
