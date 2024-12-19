/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BookBorrowDetailDao;
import entity.BookBorrowDetailEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author goyum
 */
public class BookBorrowDetailDaoImpl implements BookBorrowDetailDao{

    @Override
    public boolean create(BookBorrowDetailEntity t) throws Exception {
        //System.out.println(t);
        return CrudUtil.executeUpdate("INSERT INTO BookBorrowDetail VALUES(?,?,?)",t.getBorrowId(),t.getBookId(),t.getDueDate());
    }
    //no need
    @Override
    public boolean update(BookBorrowDetailEntity t) throws Exception {
        return false;
    }
    
    //no need
    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }
    // no need
    @Override
    public BookBorrowDetailEntity get(String id) throws Exception {
        return null;
    }
    //no need
    @Override
    public ArrayList<BookBorrowDetailEntity> getAll() throws Exception {
        return null;
    }

    @Override
    public ArrayList<BookBorrowDetailEntity> getBorrowDetailsByd(String borrowId) throws Exception {
        
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM BookBorrowDetail WHERE BorrowId = ?", borrowId);
        
        ArrayList<BookBorrowDetailEntity> bookBorrowDetailEntitys = new ArrayList<>();
        
        while (rst.next()) {
            BookBorrowDetailEntity bookBorrowDetailEntity = new BookBorrowDetailEntity( 
                    rst.getString("BorrowId"), 
                    rst.getString("BookId"), 
                    rst.getString("DueDate"));
            bookBorrowDetailEntitys.add(bookBorrowDetailEntity);
        }
        return bookBorrowDetailEntitys;
    }
    
}
