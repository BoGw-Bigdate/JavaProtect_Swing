import Target.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DaoUser extends BaseDao<User> implements UserInterface{

    @Override
    /*
     * 对User数据表进行修改
     * */
    public int UpdateUser(Connection con, String sql, Object... paramater) throws Throwable{

        return Update(con,sql,paramater);
    }

    @Override
    /*
     * 查询User数据表
     * */
    public List<User> QueryUser(Connection con, String sql, Object... paramater) throws Throwable{

        return Query(con,sql,paramater);
    }

    @Override
    /*
    创建数据库连接
    */
    public Connection getUserconnection(DataSource source) {

        Connection connection=null;
        try {
            connection = source.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    @Override
    /*
     * 关闭数据库连接
     * */
    public void CloseUserConnection(Connection con) {
        CloseDown(con);
    }

}
