import com.baizhi.Application;
import com.baizhi.dao.BookRepository;
import com.baizhi.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestSpringbootES {

    @Autowired
    private BookRepository bookRepository;

    @Test  //插入一个文档
    public void test1(){
        Book book1 = new Book(null, "水浒传", 40.2, "施耐庵", "师傅被妖怪抓走了");
        bookRepository.save(book1);
        Book book2 = new Book(null, "红楼梦", 66.6, "曹雪芹", "师傅被妖怪抓走了");
        bookRepository.save(book2);
        Book book3 = new Book(null, "三国演义", 33.3, "吴冠中", "师傅被妖怪抓走了");
        bookRepository.save(book3);
        Book book4 = new Book(null, "西游记后传", 45.5, "孙悟空", "师傅被妖怪抓走了");
        bookRepository.save(book4);
    }


    @Test //通过id查询
    public void test2(){
        Optional<Book> book = bookRepository.findById("9KjBBm0BsVw5bCHGSjy9");
        System.out.println(book.get());
    }

    @Test  //更新数据
    public void test3(){
        Book book1 = new Book(null, "水浒传", 1.0, "施耐庵", "师傅被妖怪抓走了");
        bookRepository.save(book1);
    }



    @Test   //必须通过id删除
    public void test4(){
        Book book1 = new Book();
        book1.setId("9ajGBm0BsVw5bCHGbTyB");
        bookRepository.delete(book1);
    }

    @Test   //查询所有
    public void test5(){
        Iterable<Book> books = bookRepository.findAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }


    @Test   //查询所有文档并按照价格排序
    public void test6(){
        Iterable<Book> books = bookRepository.findAll(Sort.by(Sort.Order.desc("price")));
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test//查询所有文档并分页
    public void test7(){
        Page<Book> books = bookRepository.findAll(PageRequest.of(1, 2));
        for (Book book : books) {
            System.out.println(book);
        }
    }

}
