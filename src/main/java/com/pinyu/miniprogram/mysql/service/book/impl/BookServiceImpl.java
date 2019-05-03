//package com.pinyu.miniprogram.mysql.service.book.impl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import com.pinyu.miniprogram.mysql.entity.book.BookEntity;
//import com.pinyu.miniprogram.mysql.repositry.BookRepository;
//import com.pinyu.miniprogram.mysql.service.book.BookService;
//
//@Service
//public class BookServiceImpl implements BookService{
//
//	@Autowired
//	private BookRepository bookRepository;
//	
//	
//	@Override
//    public Optional<BookEntity> findById(Long id) {
//        //CrudRepository中的方法
//        return bookRepository.findById(id);
//    }
//
//    @Override
//    public BookEntity save(BookEntity blog) {
//        return bookRepository.save(blog);
//    }
//
//    @Override
//    public void delete(BookEntity blog) {
//    	bookRepository.delete(blog);
//    }
//
//    @Override
//    public Optional<BookEntity> findOne(Long id) {
//        return bookRepository.findById(id);
//    }
//
//    @Override
//    public List<BookEntity> findAll() {
//        return (List<BookEntity>) bookRepository.findAll();
//    }
//
//    @Override
//    public Page<BookEntity> findByAuthor(String author, PageRequest pageRequest) {
//        return bookRepository.findByAuthor(author,pageRequest);
//    }
//
//    @Override
//    public Page<BookEntity> findByTitle(String title, PageRequest pageRequest) {
//        return bookRepository.findByTitle(title,pageRequest);
//    }
//
//    @Override
//    public List<BookEntity> findTitle(String titileKeyword) {
//        return bookRepository.findByTitle(titileKeyword);
//    }
//    @Override
//    public Iterable<BookEntity> saveAll(List<BookEntity> BookEntitys) {
//        return bookRepository.saveAll(BookEntitys);
//    }
//}
