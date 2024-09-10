package com.ssg.web2.todo.domain;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;
}
