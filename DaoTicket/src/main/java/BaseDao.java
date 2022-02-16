import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class BaseDao<T>{

   //    反射获取执行的类
    Class<?> clazz=null;
    {
        Type be = this.getClass().getGenericSuperclass();
        ParameterizedType so=(ParameterizedType)be;
        Type[] one = so.getActualTypeArguments();
        clazz=(Class<T>) one[0];
    }


    /*
    创建数据库连接池
    * */
    static DataSource source;
    static{
        try{
            Properties Proper = new Properties();
            String a="G:\\JavaProtect_Swing\\resources\\JdbcConnection.properties";
            InputStream In = new FileInputStream(new File(a));
            Proper.load(In);
            source = DruidDataSourceFactory.createDataSource(Proper);//得到连接池
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("创建数据库连接池失败!!!");
        }
    }

    /**
     *  数据库的增删改
     *  @return 返回数据库中数据被修改的行数
     *  @param Con 数据库的连接
     *  @param sql sql执行语句
     *  @param parameteri 填写参数(条件)
     * */
    public int Update(Connection Con, String sql, Object... parameteri) throws Exception{
        QueryRunner runner=new QueryRunner();
        int i=0;//i为修改数据的行数
        i = runner.update(Con, sql, parameteri);
        return i;
    }


    /**
     *   数据库查询
     *   @return 返回查询结果(链表)
     *   @param con 数据库的连接
     *   @param sql sql执行语句
     *   @param parameteri 填写参数(条件)
     * */
    public List<T> Query(Connection con, String sql,Object... parameteri) throws Throwable{
        QueryRunner runner=new QueryRunner();
        List<T> query=null;
        BeanListHandler<T> handler = new BeanListHandler(clazz);
        try {
            query = runner.query(con, sql, handler, parameteri);
        } catch (SQLException third) {
            third.printStackTrace();
            System.out.println("查询失败");
        }

        if("[]".equals(query.toString())) {//查询失败的情况
            query=null;
            return query;
        }
        else return query;
    }


    /**
     * @param con 要关闭的数据库连接
     * */
    public void CloseDown(Connection con) {
        if (con!=null){
            try {
                con.close();
            } catch (SQLException two) {
                two.printStackTrace();
            }
        }
        else System.out.println("连接为空");
    }
}
