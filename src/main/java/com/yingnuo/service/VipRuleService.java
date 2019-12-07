package com.yingnuo.service;

import com.yingnuo.dao.VipRuleDao;
import com.yingnuo.domain.VipRule;
import com.yingnuo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.security.auth.login.LoginException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/7
 * Time: 0:01
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class VipRuleService {
    VipRuleDao dao = new VipRuleDao();
    // 获取全部规则
    public List<VipRule> findAllVipRule() throws LoginException {
        try {
            return dao.findAllVipRule();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("获取所有会员体系规则失败");
        }
    }
    // 根据 id 修改规则
    public Boolean updateVipRuleById(VipRule vipRule) throws LoginException {
        try {
            return dao.updateVipRuleById(vipRule);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("修改规则失败");
        }
    }
    // 根据等级获取折扣
    public Double findRebateByRank(int is_rank) throws LoginException {
        try {
            return dao.findRebateByRank(is_rank).doubleValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("根据等级获取折扣失败");
        }
    }
}