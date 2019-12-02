package com.yingnuo.dao;


import com.yingnuo.domain.Order;
import com.yingnuo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    public List<Order> findOrderByUserPhone(String user_phone) throws SQLException {
        String sql = "select * from all_order where user_phone=? order by -create_date";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql,new BeanListHandler<Order>(Order.class),user_phone);
    }
}