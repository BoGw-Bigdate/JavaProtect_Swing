import Target.Ticket;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DaoTicket extends BaseDao<Ticket> implements TicketInterface {
    @Override
    /*
     * 对ticket数据表进行修改
     * */
    public int UpdateTicket(Connection con, String sql, Object... paramater) throws Throwable{
        return Update(con,sql,paramater);
    }

    @Override
    /*
     * 查询ticket数据表
     * */
    public List<Ticket> QueryTicket(Connection con, String sql, Object... paramater) throws Throwable {
        return Query(con,sql,paramater);
    }

    @Override
    /*
    创建数据库连接
    */
    public Connection getTicketconnection(DataSource source) {
        Connection Con = null;
        try {
            Con = source.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Con;
    }

    @Override
    /*
    * 关闭数据库连接
    * */
    public void CloseTicketConnection(Connection con) {
        CloseDown(con);
    }
}