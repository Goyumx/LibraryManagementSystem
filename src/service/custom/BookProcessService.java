/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.custom;

import dto.BookBorrowDto;
import service.SuperService;

/**
 *
 * @author goyum
 */
public interface BookProcessService extends SuperService{
    
    String borrowBook(BookBorrowDto bookBorrowDto)throws Exception;
    BookBorrowDto CheckDate(String borrowId) throws Exception;
    String returnBook(String borrowId, double Fines) throws Exception;
    
}
