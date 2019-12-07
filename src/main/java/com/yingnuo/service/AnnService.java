package com.yingnuo.service;

import com.yingnuo.dao.AnnDao;
import com.yingnuo.domain.Ann;
import com.yingnuo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/6
 * Time: 22:02
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class AnnService {
    AnnDao dao = new AnnDao();
    // 查询所有公告
    public List<Ann> findAllAnn() throws LoginException {
        try {
            return dao.findAllAnn();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("获取所有公告失败");
        }
    }
    // 根据公告名字找公告
    public Ann findAnnByAnnName(String ann_name) throws LoginException {
        try {
            return dao.findAnnByAnnName(ann_name);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("获取所有公告"+ ann_name +"失败");
        }
    }
    // 根据公告名称修改公告
    public Boolean updateAnnByAnnName(Ann ann) throws LoginException{
        try {
            return dao.updateAnnByAnnName(ann);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("修改公告失败");
        }
    }
}