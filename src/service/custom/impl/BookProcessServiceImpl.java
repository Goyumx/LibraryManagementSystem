/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.custom.impl;

import dao.DaoFactory;
import dao.custom.BookBorrowDao;
import dao.custom.BookBorrowDetailDao;
import dao.custom.BookDao;
import db.DBConnection;
import dto.BookBorrowDetailDto;
import dto.BookBorrowDto;
import entity.BookBorrowDetailEntity;
import entity.BookBorrowEntity;
import entity.BookEntity;
import service.custom.BookProcessService;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author goyum
 */
public class BookProcessServiceImpl implements BookProcessService{
    
    private BookBorrowDao bookBorrowDao = (BookBorrowDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOKBORROW);
    private BookBorrowDetailDao bookBorrowDetailDao = (BookBorrowDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOKBORROWDETAIL);
    private BookDao bookDao = (BookDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);

    @Override
    public String borrowBook(BookBorrowDto bookBorrowDto) throws Exception {
        
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(new Date());
                
                
            BookBorrowEntity bookBorrowEntity = new BookBorrowEntity(bookBorrowDto.getBorrowId(), bookBorrowDto.getMemberId(), date, bookBorrowDto.getDueDate());
            if(bookBorrowDao.create(bookBorrowEntity)){
                boolean isBookBorrowDetailSaved = true;
 
                for (BookBorrowDetailDto bookBorrowDetailDto : bookBorrowDto.getBookBorrowDetailDtos()) {
                    BookBorrowDetailEntity bookBorrowDetailEntity = new BookBorrowDetailEntity(
                            bookBorrowDetailDto.getBorrowId(), 
                            bookBorrowDetailDto.getBookId(), 
                            bookBorrowDetailDto.getDueDate());
                    if(!bookBorrowDetailDao.create(bookBorrowDetailEntity)){
                        isBookBorrowDetailSaved = false;
                    }
                }
                if(isBookBorrowDetailSaved){
                    
                    boolean isBookUpdated = true;
                    for (BookBorrowDetailDto bookBorrowDetailDto : bookBorrowDto.getBookBorrowDetailDtos()) {
                        BookEntity bookEntity = bookDao.get(bookBorrowDetailDto.getBookId());
                        if(bookEntity!=null){
                            bookEntity.setStates("Unavailable");
                            if(!bookDao.update(bookEntity)){
                                isBookUpdated = false;
                            }
                        }
                    }

                    if(isBookUpdated){
                        
                        connection.commit();
                        return "Success";
                        
                    }else{
                        connection.rollback();
                        return "Error in Updating Book States";
                    }
                       
                }else{
                    connection.rollback();
                    return "Error in saving Borrowing Detail Process";
                }
                
            }else{
                connection.rollback();
                return "Error in saving Borrowing Process";
            }
            
            
            
        } catch (Exception e) {
            
            connection.rollback();
            e.printStackTrace();
            throw e;
            
        } finally {
            
            connection.setAutoCommit(true);
        }
    }

    
    
    @Override
    public String returnBook(String borrowId, double Fines) throws Exception {
        
        
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            BookBorrowEntity bookBorrowEntity = bookBorrowDao.get(borrowId);
            
            if(bookBorrowEntity!=null){
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(new Date());
                
                bookBorrowEntity.setReturnDate(date);
                bookBorrowEntity.setFines(Fines);
                
                if(bookBorrowDao.update(bookBorrowEntity)){
                    boolean isBookUpdated = true;
                
                    ArrayList<BookBorrowDetailEntity> bookBorrowDetailEntitys = bookBorrowDetailDao.getBorrowDetailsByd(borrowId);
                    for (BookBorrowDetailEntity bookBorrowDetailEntity : bookBorrowDetailEntitys) {
                        BookEntity bookEntity = bookDao.get(bookBorrowDetailEntity.getBookId());
                        if (bookEntity != null) {
                            bookEntity.setStates("Available");
                            if(!bookDao.update(bookEntity)){
                                isBookUpdated = false;
                            }
                        }  
                    }
                    
                    if(isBookUpdated){
                        connection.commit();
                        return "Return Processed Successfully!";
                    } else{
                        connection.rollback();
                        return "Book Statees Changing Error";
                    }                                        
                }else{
                    connection.rollback();
                    return "Return Save Error";
                }       
            }else{
                connection.rollback();
                return "Invalid Borrow ID";
            }
        } catch (Exception e) {
            
            connection.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            
            connection.setAutoCommit(true);
        }
    }
    
}
