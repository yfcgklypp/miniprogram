package com.pinyu.miniprogram.mysql.service.book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.pinyu.miniprogram.mysql.entity.book.BookEntity;

public interface BookService {
	
	Optional<BookEntity> findById(Long id);

    BookEntity save(BookEntity blog);

    void delete(BookEntity blog);

    Optional<BookEntity> findOne(Long id);

    List<BookEntity> findAll();

    Page<BookEntity> findByAuthor(String author, PageRequest pageRequest);

    Page<BookEntity> findByTitle(String title, PageRequest pageRequest);

    List<BookEntity> findTitle(String titileKeyword);

    Iterable<BookEntity> saveAll(List<BookEntity> books);

}
