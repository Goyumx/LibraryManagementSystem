/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dto.BookCategoryDto;
import java.util.ArrayList;
import service.ServiceFactory;
import service.custom.BookCategoryService;

/**
 *
 * @author goyum
 */
public class BookCategoryController {
    
    private BookCategoryService bookCategoryService = (BookCategoryService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOKCATEGORY);
    
    public String save(BookCategoryDto bookCategoryDto) throws Exception{
        return bookCategoryService.save(bookCategoryDto);
    }
    
    public String update(BookCategoryDto bookCategoryDto) throws Exception{
        return bookCategoryService.update(bookCategoryDto);
    }
    
    public String delete(String bookCategoryId) throws Exception{
        return bookCategoryService.delete(bookCategoryId);
    }
    
    public  ArrayList<BookCategoryDto> getAll() throws Exception{
        return bookCategoryService.getAll();
    }
    
    public BookCategoryDto get(String bookCategoryId) throws Exception{
        return bookCategoryService.get(bookCategoryId);
    }
}
