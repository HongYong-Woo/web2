package com.ssg.web2.todo.controller;

import com.ssg.web2.todo.domain.TodoVO;
import com.ssg.web2.todo.dto.TodoDTO;
import com.ssg.web2.todo.service.TodoService;
import com.sun.tools.javac.comp.Todo;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("/todo/list.............call");
        log.info("TodoListController doGet !!!");
         try {
             List<TodoDTO> dtoList = todoService.listAll();
             req.setAttribute("dtoList", dtoList);
             req.getRequestDispatcher("/todo/list.jsp").forward(req,resp);
         } catch (Exception e){
             log.error(e.getMessage());
             throw new ServletException("list error");
         }





/*//         List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
//        req.setAttribute("dtolist", dtoList);

        try {
          //  List<TodoVO> voList = TodoService.INSTANCE.getList();
          //  req.setAttribute("volist", voList);
            req.getRequestDispatcher("/todo/list.jsp").forward(req,resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/





    }


}
