package com.pinyu.miniprogram.mysql.entity.book;

//import org.springframework.data.elasticsearch.annotations.Document;

import com.pinyu.miniprogram.mysql.entity.BaseEntity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
//@Document(indexName = "book", type = "_doc")
public class BookEntity extends BaseEntity{

    private String title;
    private String author;
    private String postDate;
    
    public BookEntity(Long id, String title,String author,String postDate){
    	setId(id);
    	this.title=title;
    	this.author=author;
    	this.postDate=postDate;
    }

}

