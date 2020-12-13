import com.june.dao.BookMapper;
import com.june.pojo.Books;
import com.june.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MapperTest {
    @Test
    public void Test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl bookServiceImpl = context.getBean("BookServiceImpl", BookServiceImpl.class);
//        Books book = new Books(7,"jav2a",1111,"sss");

        System.out.println( bookServiceImpl.queryBookByID(4));
    }

}
