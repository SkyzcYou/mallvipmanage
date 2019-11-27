package com.yingnuo.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/mallInfo")
public class MallInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();

        String name = "樱诺商城";
        String phoneNumber = "026-75078";
        String address = "内蒙古呼和浩特市经济技术开发区金川工业园区";
//
//        printWriter.println(name);
//        printWriter.println(phoneNumber);
//        printWriter.println(address);
        req.setAttribute("name",name);
        req.setAttribute("phoneNumber",phoneNumber);
        req.setAttribute("address",address);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/about.jsp");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
