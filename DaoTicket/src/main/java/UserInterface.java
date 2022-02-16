import Target.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;
public interface UserInterface {
    /*
     * 对user数据表进行增删改
     * */
    int UpdateUser(Connection con, String sql, Object... paramater) throws Throwable;


    /*
     *关闭连接
     * */
    void CloseUserConnection(Connection con);


    /*
     * 获取连接
     * */
    Connection getUserconnection(DataSource source);


    /*
     * 返回查询对象
     * */
    List<User> QueryUser(Connection con, String sql, Object... paramater) throws Throwable;
}
