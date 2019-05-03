//package com.pinyu.miniprogram.mysql.repositry;
//
//import java.util.List;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//
//import com.pinyu.miniprogram.mysql.entity.book.BookEntity;
//
//public interface BookRepository extends ElasticsearchRepository<BookEntity,Long>{
//	
//	Page<BookEntity> findByAuthor(String author, Pageable pageable);
//
//    Page<BookEntity> findByTitle(String title, Pageable pageable);
//
//    List<BookEntity> findByTitle(String title);
//
//}
