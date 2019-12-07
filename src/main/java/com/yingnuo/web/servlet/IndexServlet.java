package com.yingnuo.web.servlet;

import com.yingnuo.domain.Ann;
import com.yingnuo.service.AnnService;

import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnnService annService = new AnnService();
        try {
            Ann ann =annService.findAnnByAnnName("循环通知");
            String loop_notice = ann.getAnn_content();
            String[] loop_noticeArray = loop_notice.split("&");
            Ann ann1 = annService.findAnnByAnnName("公告板");
            req.setAttribute("loopNoticeArray",loop_noticeArray);
            req.setAttribute("blackboard",ann1.getAnn_content());
        } catch (LoginException e) {
            e.printStackTrace();
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {

    }
}
