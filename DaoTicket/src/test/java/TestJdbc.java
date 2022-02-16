import Target.Ticket;
import Target.User;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class TestJdbc {
    @Test
    public void first() throws Exception {
        Properties Proper = new Properties();
        String a = "src/test/resources/JdbcConnection.properties";
        InputStream In = new FileInputStream(new File(a));
//        In=String.class.getClassLoader().getResourceAsStream(a);
        Proper.load(In);
        DataSource source = DruidDataSourceFactory.createDataSource(Proper);
        Connection connection = source.getConnection();
        System.out.println(connection);
        System.out.println();
    }

    @Test
    public void Second() {
        DaoUser daoUser = new DaoUser();
        String a = "delete from registrants";
        Connection ticketconnection = daoUser.getUserconnection(BaseDao.source);
        int user = 0;
        try {
            user = daoUser.UpdateUser(ticketconnection, a);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("删除错误");
        }
        daoUser.CloseDown(ticketconnection);
//        System.out.println(one.toString().equals(user.toString()));
    }

    @Test
    public void Thirt() {
        QueryRunner runner = new QueryRunner();
        String a = "select * from tickets where FilmName=?";
        BeanListHandler<Ticket> handler = new BeanListHandler(Ticket.class);
        Connection b = null;
        try {
            b = BaseDao.source.getConnection();
            List<Ticket> tickets = runner.query(b, a, handler, "雷神4");
            System.out.println(tickets);
            /*PreparedStatement preparedStatement = b.prepareStatement(a);
            preparedStatement.setString(1,"长津河之水门桥");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }*/
            b.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
