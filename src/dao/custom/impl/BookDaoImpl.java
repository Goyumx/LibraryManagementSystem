/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BookDao;
import entity.BookEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author goyum
 */
public class BookDaoImpl implements BookDao{

    @Override
    public boolean create(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Book VALUES(?,?,?,?,?)", t.getBookID(), t.getBookTitle(), t.getCategoryId(), t.getDescription(), t.getStates());
    }

    @Override
    public boolean update(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Book SET BookTitle= ?, CategoryId= ?, BookDescription=?, BookStates=? WHERE BookId =?", t.getBookTitle(),t.getCategoryId(),t.getDescription(),t.getStates(),t.getBookID());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Book WHERE BookId = ?", id);
    }

    @Override
    public BookEntity get(String id) throws Exception {
       
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Book WHERE BookId = ?", id);
        
        if(rst.next()){
            BookEntity bookEntity = new BookEntity(
                    rst.getString("BookId"),
                    rst.getString("BookTitle"),
                    rst.getString("CategoryId"), 
                    rst.getString("BookDescription"), 
                    rst.getString("BookStates"));
            return bookEntity;
        }
        return null;
    }

    @Override
    public ArrayList<BookEntity> getAll() throws Exception {
        ArrayList<BookEntity> bookEntitys = new ArrayList<>();
        
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Book");
        
        while (rst.next()) {            
            BookEntity bookEntity = new BookEntity(
                    rst.getString("BookId"),
                    rst.getString("BookTitle"),
                    rst.getString("CategoryId"), 
                    rst.getString("BookDescription"), 
                    rst.getString("BookStates"));
            bookEntitys.add(bookEntity);
        }
        return bookEntitys;
    }
    
}
