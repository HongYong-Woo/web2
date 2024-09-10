package com.ssg.web2.todo.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
@Log4j2     //세션을 이용한 로그아웃
public class LogoutController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("logoutController Post");



        HttpSession session = req.getSession(); //HttpSession을 이용해서 setAttribute()를 사용자공간에 loginInfo라는 이름으로 문자열을 보관
        session.removeAttribute("logInfo");
        session.invalidate();
        resp.sendRedirect("/login");
    }
}
