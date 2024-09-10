package com.ssg.web2.todo.controller;

import com.ssg.web2.todo.dto.MemberDTO;
import com.ssg.web2.todo.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginController", value = "/login")
@Log4j2
public class LoginController extends HttpServlet {

    //get 은 로그인 화면을 보여주고 Post 방식으로 실제 로그인 처리하도록 구성한다.
    //1. wevServlet 해당 컨트롤러 등록 이름 /login
    //2. doget login.jsp파일로 포워딩
    //3. login.jsp 파일로 만들어 주세요... text 2개 id(mid), pwd(mpw), submit버튼

    private MemberService  memberService  = MemberService.INSTANCE ;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("loginController Get");
        req.getRequestDispatcher("/todo/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("loginController Post");
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw"); //파라미터 수집


        try {
            MemberDTO dto = memberService.login(mid, mpw);
            if(dto.getMid() != null) {
                String str = mid + mpw;
                HttpSession session = req.getSession(); //HttpSession을 이용해서 setAttribute()를 사용자공간에 loginInfo라는 이름으로 문자열을 보관
                session.setAttribute("loginInfo", str);
                resp.sendRedirect("/todo/list");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
