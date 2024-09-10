import com.ssg.web2.todo.dao.MemberDAO;
import com.ssg.web2.todo.domain.MemberVO;
import org.junit.jupiter.api.Test;

public class MemberDAOTest {



    @Test
    public void memberDAOTest() throws Exception {
        MemberDAO dao = new MemberDAO();
        MemberVO vo = dao.getWithPassword("user00", "0000");
        System.out.println("test : " + vo.getMid());
    }

}
