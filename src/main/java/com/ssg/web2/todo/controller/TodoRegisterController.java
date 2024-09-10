package com.ssg.web2.todo.controller;


import com.ssg.web2.todo.dto.TodoDTO;
import com.ssg.web2.todo.service.TodoService;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Log4j2
@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    TodoService todoService = TodoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("입력화면 register.jsp 로 GET");
        log.info("입력화면 register.jsp 로 GET");

        HttpSession session = req.getSession();

        if(session.isNew()) { //기존에 JSESSIONID 가 없는 사용자
            log.info("JSESSIONID 쿠키가 새로 생성된 사용자입니다.");
            resp.sendRedirect("/login");
            return;
        }

     /*   if(session.getAttribute("loginInfo") == null) {
            log.info("로그인 정보가 없는 사용자입니다.");
            resp.sendRedirect("/login");
        }*/


        req.getRequestDispatcher("/todo/register.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("입력을 처리하고 목록 페이지 이동");
        log.info("입력을 처리하고 목록 페이지 이동");

        TodoDTO dto = TodoDTO.builder().title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("date"))) //
                .build();

        log.info(dto);

        try {
            todoService.register(dto);
        } catch (Exception e) {
           e.printStackTrace();
        }
        resp.sendRedirect("/todo/list");


        /*TodoVO vo = TodoVO.builder().tno(null)
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("date"))) //
                        .finished(false).build();
        System.out.println(vo);

        try {
            TodoService.INSTANCE.register(vo);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

    }


}
