import Target.User;

import javax.swing.*;
import java.sql.Connection;
import java.util.List;

/*
 * 登录操作处理
 * */
public class LoginHandle {
    static DaoUser daoUser=new DaoUser();

    public Login LoginAction(Login login){
        Connection userconnection = daoUser.getUserconnection(BaseDao.source);

        String sql1="select * from registrants";
        boolean registered=false;//判断账户是否存在
        List<User> users=null;
        try {
            users = daoUser.QueryUser(userconnection,sql1);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("查询失败");
        }
        if (users!=null){
            for (User user : users) {
                if (login.ID.equals(user.getID())){
                    registered=true;
                }
            }
        }
        List<User> user = null;
        String sql2 = "select * from registrants where ID=? and Password=?";
        try {
            users = daoUser.QueryUser(userconnection, sql2, login.getID(), login.getPassword());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("查询失败");
        }
        if (users == null) {
            if ("".equals(login.ID)) {//判断账号是否为空
                login.setSuccess(false);
                JOptionPane.showMessageDialog(null, "账号ID没有填写,请输入账号", "抱歉", JOptionPane.WARNING_MESSAGE);
            }
            else {
                if (!registered) {
                    login.setSuccess(false);
                    JOptionPane.showMessageDialog(null, "输入账号不存在,", "抱歉", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    login.setSuccess(false);
                    JOptionPane.showMessageDialog(null, "密码错误,", "抱歉", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else {
            login.setSuccess(true);
            JOptionPane.showMessageDialog(null, "登录成功", "恭喜", JOptionPane.WARNING_MESSAGE);
        }
        daoUser.CloseDown(userconnection);
        return login;
    }
}

