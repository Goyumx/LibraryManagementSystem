/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dto.BookBorrowDto;
import service.ServiceFactory;
import service.custom.BookProcessService;

/**
 *
 * @author goyum
 */
public class BookProcessController {
    
    private BookProcessService bookProcessService = (BookProcessService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK_PROCESS);
    
    public String borrowBook(BookBorrowDto bookBorrowDto)throws Exception{
        
        return bookProcessService.borrowBook(bookBorrowDto);
        
    }
    
    public String returnBook(String borrowId, double Fines) throws Exception {
        return bookProcessService.returnBook(borrowId, Fines);
    }

    public BookBorrowDto checkDate(String boorowId) throws Exception{
        return bookProcessService.CheckDate(boorowId);
    }
}
