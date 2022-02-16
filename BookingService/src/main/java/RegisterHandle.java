import Target.User;

import javax.swing.*;
import java.sql.Connection;

/*
*注册用户处理
* */
public class RegisterHandle {
    public void RegisterAction(User user) {
        boolean success=true;//判断账号是否为空
        DaoUser daoUser = new DaoUser();
        Connection connection =daoUser.getUserconnection(BaseDao.source);
        String sql="insert into registrants(ID,Password,Name,Age) values(?,?,?,?)";
        String id = user.getID();
        String password = user.getPassword();
        if ("".equals(id)||"".equals(password)){
            success=false;
        }
        String name = user.getName();
        String age = user.getAge();
        int i = 0;
        if (success){
            try {
                i = daoUser.Update(connection, sql, id, password, name, age);
            } catch (Exception e) {
                e.printStackTrace();
            }
            daoUser.CloseDown(connection);//关闭连接
            if (i > 0) {
                JOptionPane.showMessageDialog(null,"注册成功","恭喜",JOptionPane.WARNING_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null,"ID不能重复","警告",JOptionPane.WARNING_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null,"id和密码必须填写","警告",JOptionPane.WARNING_MESSAGE);
        }
        daoUser.CloseDown(connection);
    }
}
