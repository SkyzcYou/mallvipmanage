package com.yingnuo.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yingnuo.domain.Ann;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/6
 * Time: 21:48
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class AnnTest {
    public static DataSource dataSourceTest = null;
    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        dataSourceTest = cpds;
    }

    public static void main(String[] args) {
        AnnDao annDao = new AnnDao();
        try {
            List<Ann> annList = annDao.findAllAnn();
            for (Ann ann : annList){
                System.out.println(ann.toString());
            }
            Ann myann = annDao.findAnnByAnnName("循环通知");
            System.out.println(myann.getAnn_content());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}