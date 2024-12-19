/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.custom;

import dto.BookCategoryDto;
import java.util.ArrayList;
import service.SuperService;

/**
 *
 * @author goyum
 */
public interface BookCategoryService extends SuperService{
    
    String save(BookCategoryDto bookCategoryDto) throws Exception;
    String update(BookCategoryDto bookCategoryDto) throws Exception;
    String delete(String bookCategoryId) throws Exception;
    BookCategoryDto get(String bookCategoryId) throws Exception;
    ArrayList<BookCategoryDto> getAll() throws Exception;
}
