package controller;

import dto.BookDto;
import java.util.ArrayList;
import service.ServiceFactory;
import service.custom.BookService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author goyum
 */
public class BookController {
    
    private BookService bookService = (BookService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);
    
    public String save(BookDto book) throws Exception{
        return bookService.save(book);
    }
    
    public String update(BookDto book) throws Exception{
        return bookService.update(book);
    }
    
    public String delete(String bookId) throws Exception{
        return bookService.delete(bookId);
    }
    
    public  ArrayList<BookDto> getAll() throws Exception{
        return bookService.getAll();
    }
    
    public BookDto get(String bookId) throws Exception{
        return bookService.get(bookId);
    }
    
}

