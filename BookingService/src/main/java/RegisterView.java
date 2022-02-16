import Target.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* 注册界面
* */
public class RegisterView extends JPanel implements ActionListener{
    JTextField ID,Name,Age;
    JPasswordField Password;
    JButton RegisterJButton;

    public RegisterView() {
        ID=new JTextField(10);
        Password=new JPasswordField(10);
        Name=new JTextField(10);
        Age=new JTextField(10);
        RegisterJButton= new JButton("注册");
        add(new Label("ID:"));
        add(ID);
        add(new Label("Password:"));
        add(Password);
        add(new Label("Nmae:"));
        add(Name);
        add(new Label("Age:"));
        add(Age);
        add(RegisterJButton);
        RegisterJButton.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        User user = new User(ID.getText(), new String(Password.getPassword()), Name.getText(), Age.getText());
        RegisterHandle registerHandle = new RegisterHandle();
        registerHandle.RegisterAction(user);
    }
}
