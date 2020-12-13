package com.june.service;

import com.june.pojo.Books;

import java.util.List;

public interface BookService {

    int addBook(Books books);

    int deleteBookByID(int id);

    int updateBook(Books books);

    Books queryBookByID(int id);

    List<Books> queryAllBooks();

    Books queryBookByName(String bookName);
}
