package com.yingnuo.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yingnuo.service.VipRuleService;

import javax.security.auth.login.LoginException;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/7
 * Time: 18:29
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class getRebateByRankTest {
    public static DataSource dataSourceTest = null;
    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        dataSourceTest = cpds;
    }

    public static void main(String[] args) {
        VipRuleDao dao = new VipRuleDao();
        VipRuleService vipRuleService = new VipRuleService();
        try {
            System.out.println(vipRuleService.findRebateByRank(3));
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}