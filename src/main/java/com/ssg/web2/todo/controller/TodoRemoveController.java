package com.ssg.web2.todo.controller;

import com.ssg.web2.todo.service.TodoService;
import jdk.jpackage.internal.Log;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "todoRemoveController", urlPatterns = "/todo/remove")
public class TodoRemoveController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long tno = Long.parseLong(req.getParameter("tno"));
        log.info(tno);
        try {
            todoService.remove(tno);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException(e);
        }
        resp.sendRedirect("/todo/list");


        /*try {
           // System.out.println("delete tno : " + req.getParameter("tno"));
        //    TodoService.INSTANCE.delete(Long.parseLong(req.getParameter("tno")));
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }
}
