package com.ssg.web2.todo.dao;

import com.ssg.web2.todo.domain.TodoVO;
import com.ssg.web2.todo.dto.TodoDTO;
import lombok.Cleanup;
import lombok.Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class TodoDAO {
    public void insert(TodoVO vo) throws Exception{
            String query = "INSERT INTO tbl_todo (tno, title, dueDate, finished) values(null, ?, ?, ?)";

            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement psmt = connection.prepareStatement(query);

            psmt.setString(1, vo.getTitle());
            psmt.setDate(2, Date.valueOf(vo.getDueDate()));
            psmt.setBoolean(3, vo.isFinished());

            psmt.executeUpdate();
    }

    public List<TodoVO> selectAllList() throws Exception{
        String query = "SELECT * FROM tbl_todo";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(query);
        @Cleanup ResultSet rs = psmt.executeQuery();

        List<TodoVO> list = new ArrayList<>();
        while(rs.next()) {
            TodoVO vo = TodoVO.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished")).build();

            list.add(vo);
        }
        return list;
    }

    public TodoVO selectOne(Long tno) throws Exception{
        String query = "SELECT * FROM tbl_todo WHERE tno = " + tno;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(query);
        @Cleanup ResultSet rs = psmt.executeQuery();

        rs.next();
        TodoVO vo = TodoVO.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished")).build();

        return vo;
    }

    public void delete(Long tno) throws Exception {
        String query = "DELETE FROM tbl_todo WHERE tno = " + tno;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(query);
        psmt.executeUpdate();

    }

    public void updateOne(TodoVO vo) throws Exception {
        String query = "UPDATE tbl_todo SET title = ?, dueDate = ?, finished = ? WHERE tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(query);

        psmt.setString(1, vo.getTitle());
        psmt.setDate(2, Date.valueOf(vo.getDueDate()));
        psmt.setBoolean(3, vo.isFinished());
        psmt.setLong(4, vo.getTno());

        psmt.executeUpdate();

    }
}
