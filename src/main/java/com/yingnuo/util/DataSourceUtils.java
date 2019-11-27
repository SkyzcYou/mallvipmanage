package com.yingnuo.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
*  获取数据源和数据库连接
* */
public class DataSourceUtils {
    private static DataSource dataSource = new ComboPooledDataSource();
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    public static DataSource getDataSource(){
        return dataSource;
    }
    /*
    *  当 DBUtils 需要手动控制事务时，调用此方法获得连接
    * */
    public static Connection getConnection() throws SQLException{
        Connection connection = threadLocal.get();
        if (connection == null){
            connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }
    /*
    *  开启事务
    * */
    public static void startTransaction() throws SQLException{
        Connection connection = getConnection();
        if (connection != null){
            connection.setAutoCommit(false);
        }
    }
    /*
    *  从 ThreadLocal 中释放并关闭 Connection ,并结束事务
    * */
    public static void releaseAndCloseConnection() throws SQLException{
        Connection connection = getConnection();
        if (connection != null){
            connection.commit();
            threadLocal.remove();
            connection.close();
        }
    }
    /*
    *  事务回滚
    * */
    public static void rollback() throws SQLException{
        Connection connection = getConnection();
        if (connection != null){
            connection.rollback();
        }
    }
}
