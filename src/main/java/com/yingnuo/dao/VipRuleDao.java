package com.yingnuo.dao;

import com.yingnuo.domain.Admin;
import com.yingnuo.domain.Ann;
import com.yingnuo.domain.User;
import com.yingnuo.domain.VipRule;
import com.yingnuo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;


public class VipRuleDao {
    // 获取全部规则
    public List<VipRule> findAllVipRule() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from vip_rule";
        return runner.query(sql,new BeanListHandler<VipRule>(VipRule.class));
    }
    // 根据 id 修改规则
    public Boolean updateVipRuleById(VipRule vipRule) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update vip_rule set max_point=?,is_rank=?,rebate=? where id=?";
        int num = runner.update(sql,vipRule.getMax_point(),vipRule.getIs_rank(),vipRule.getRebate(),vipRule.getId());
        return num>0;
    }
    // 根据等级获取折扣
    public BigDecimal findRebateByRank(int is_rank) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select rebate from vip_rule where is_rank=?";
        BigDecimal rebate = (BigDecimal) runner.query(sql,new ScalarHandler(),is_rank);
        return rebate;
    }
}