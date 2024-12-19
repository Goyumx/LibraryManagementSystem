/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BookBorrowDao;
import entity.BookBorrowEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author goyum
 */
public class BookBorrowDaoImpl implements BookBorrowDao{

    @Override
    public boolean create(BookBorrowEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO BookBorrow VALUES(?,?,?,?,?,?)",
                t.getBorrowId(),t.getMemberId(),t.getBorrowDate(),t.getDueDate(),t.getReturnDate(),t.getFines());
    }

    @Override
    public boolean update(BookBorrowEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE BookBorrow SET ReturnDate = ?, Fines = ? WHERE BorrowId = ?", t.getReturnDate(),t.getFines(),t.getBorrowId());
    }
    
    //no need
    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public BookBorrowEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM BookBorrow WHERE BorrowId = ?", id);
        if(rst.next()){
            BookBorrowEntity bookBorrowEntity= new BookBorrowEntity(
                    rst.getString("BorrowId"), 
                    rst.getString("MemberId"), 
                    rst.getString("BorrowDate"),  
                    rst.getString("DueDate"),  
                    rst.getString("ReturnDate"), 
                    rst.getDouble("Fines"));
            return bookBorrowEntity;
    }
        return null;
    }
   
    // no need
    @Override
    public ArrayList<BookBorrowEntity> getAll() throws Exception {
        return null;
    }
    
}
