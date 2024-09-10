package com.ssg.web2.todo.dao;

import com.ssg.web2.todo.domain.MemberVO;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Log4j2
public class MemberDAO {

    public MemberVO getWithPassword(String mid, String mpw) throws Exception{
        String query = "SELECT * FROM tbl_member WHERE mid = '" + mid +
                "' AND mpw = '" + mpw + "'";
        log.info(query);
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(query);
        @Cleanup ResultSet rs = psmt.executeQuery();
        MemberVO vo = null;
        if(rs.next())
        {
            vo = MemberVO.builder()
                    .mid(rs.getString("mid"))
                    .mpw(rs.getString("mpw"))
                    .mname(rs.getString("mname")).build();
        }


        return vo;
    }
}
