package com.ssg.web2.todo.controller;

import com.ssg.web2.todo.dao.TodoDAO;
import com.ssg.web2.todo.domain.TodoVO;
import com.ssg.web2.todo.dto.TodoDTO;
import com.ssg.web2.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(name = "todoModifyController", value = "/todo/modify")
public class TodoModifyController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long tno = Long.parseLong(req.getParameter("tno"));

        try {
            TodoDTO dto = todoService.get(tno);
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/todo/modify.jsp").forward(req,resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException(e);
        }


        /*Long tno = Long.parseLong(req.getParameter("tno"));
        try {
           // TodoVO vo = TodoService.INSTANCE.get(tno);
          //  req.setAttribute("vo", vo);
            req.getRequestDispatcher("/todo/modify.jsp").forward(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String finishedStr = req.getParameter("finished");

        TodoDTO dto = TodoDTO.builder().tno(Long.parseLong(req.getParameter("tno")))
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("date"), DATETIMEFORMATTER))
                .finished(finishedStr != null && finishedStr.equals("on")).build();

        log.info("todo Modify Controller ......POST");
        log.info(dto);

        try {
            todoService.modify(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/todo/list");

        /* boolean finishedCheck = false;
        if(req.getParameter("finished") == null) { finishedCheck = false;}
        else {finishedCheck = true;}
        System.out.println("finish : " + finishedCheck );

        TodoVO vo = TodoVO.builder().tno(Long.parseLong(req.getParameter("tno")))
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("date")))
                .finished(finishedCheck).build();

        try {
          //  TodoService.INSTANCE.update(vo);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }
}
