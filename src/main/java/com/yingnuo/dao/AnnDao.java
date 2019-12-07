package com.yingnuo.dao;

import com.yingnuo.domain.Admin;
import com.yingnuo.domain.Ann;
import com.yingnuo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/6
 * Time: 21:45
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class AnnDao {
    // 查询所有公告
    public List<Ann> findAllAnn() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from ann";
        return runner.query(sql,new BeanListHandler<Ann>(Ann.class));
    }
    // 根据公告名字找公告
    public Ann findAnnByAnnName(String ann_name) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from ann where ann_name=?";
        return runner.query(sql,new BeanHandler<Ann>(Ann.class),ann_name);
    }
    // 根据公告名称修改公告
    public Boolean updateAnnByAnnName(Ann ann) throws SQLException{
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update ann set ann_content=? where ann_name=?";
        int num = runner.update(sql,ann.getAnn_content(),ann.getAnn_name());
        return num>0;
    }
}