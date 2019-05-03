//package com.pinyu.miniprogram.web.controller.book;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.pinyu.miniprogram.mysql.entity.book.BookEntity;
//import com.pinyu.miniprogram.mysql.service.book.BookService;
//
//@Controller
//@RequestMapping("/es")
//public class BookController {
//
//	@Autowired
//    private BookService bookService;
//
//    @RequestMapping("/book/{id}")
//    @ResponseBody
//    public BookEntity getBookEntityById(@PathVariable Long id){
//        Optional<BookEntity> opt =bookService.findById(id);
//        BookEntity book=opt.get();
//        System.out.println(book);
//        return book;
//    }
//
//    @RequestMapping("/save")
//    @ResponseBody
//    public void Save(){
//        BookEntity book1=new BookEntity(1L,"ES入门教程","ypp","2018-10-01");
//        BookEntity book2=new BookEntity(2L,"从ES入门教程到放弃java","ypp","2018-10-01");
//        BookEntity book3=new BookEntity(3L,"mysql从入门到放弃","ypp","2018-10-01");
//        BookEntity book4=new BookEntity(4L,"redis从入门到放弃","ypp","2018-10-01");
//        BookEntity book5=new BookEntity(5L,"spark从入门到放弃","ypp","2018-10-01");
//        BookEntity book6=new BookEntity(6L,"hbase从入门到放弃","ypp","2018-10-01");
//        BookEntity book7=new BookEntity(7L,"zookeeper从入门到放弃","ypp","2018-10-01");
//        BookEntity book8=new BookEntity(8L,"mq从入门到放弃","ypp","2018-10-01");
//        BookEntity book9=new BookEntity(9L,"spring cloud从入门到放弃","ypp","2018-10-01");
//        List<BookEntity> books=new ArrayList<>();
//        books.add(book1);
//        books.add(book2);
//        books.add(book3);
//        books.add(book4);
//        books.add(book5);
//        books.add(book6);
//        books.add(book7);
//        books.add(book8);
//        books.add(book9);
//        try {
//			
//        	bookService.saveAll(books);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    }
//
//    @RequestMapping("/keyword")
//    @ResponseBody
//    public List<BookEntity> keyword(@RequestParam("keyword")String keyword){
//        return bookService.findTitle(keyword);
//    }
//}
