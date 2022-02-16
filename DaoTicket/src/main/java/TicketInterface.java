import Target.Ticket;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

public interface TicketInterface {
    /*
    * 对数据库进行增删改
    * */
    int UpdateTicket(Connection con, String sql,Object... paramater) throws Throwable;


    /*
    *关闭连接
    * */
    void CloseTicketConnection(Connection con);


    /*
    * 获取连接
    * */
    Connection getTicketconnection(DataSource source);


    /*
    * 返回查询对象
    * */
    List<Ticket> QueryTicket(Connection con, String sql,Object... paramater) throws Throwable;
}
