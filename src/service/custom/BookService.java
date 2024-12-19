/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.custom;

import dto.BookDto;
import java.util.ArrayList;
import service.SuperService;

/**
 *
 * @author goyum
 */
public interface BookService extends SuperService{
    
    String save(BookDto bookDto) throws Exception;
    String update(BookDto bookDto) throws Exception;
    String delete(String bookId) throws Exception;
    BookDto get(String bookId) throws Exception;
    ArrayList<BookDto> getAll() throws Exception;
    
}
