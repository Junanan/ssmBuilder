package com.june.dao;

import com.june.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int addBook(Books books);

    int deleteBookByID(@Param("bookID") int id);

    int updateBook(Books books);

    Books queryBookByID(@Param("bookID") int id);

    List<Books> queryAllBooks();

    Books queryBookByName(@Param("bookName") String bookName);
}
