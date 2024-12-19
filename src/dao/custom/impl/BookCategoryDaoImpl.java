/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BookCategoryDao;
import entity.BookCategoryEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author goyum
 */
public class BookCategoryDaoImpl implements BookCategoryDao{

    @Override
    public boolean create(BookCategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO BookCaregory VALUES(?,?,?)", t.getCategoryId() , t.getCategoryName(), t.getCategoryDesc());
    }

    @Override
    public boolean update(BookCategoryEntity t) throws Exception {
      return CrudUtil.executeUpdate("UPDATE BookCategory SET CategoryDescription= ?, CategoryName= ? WHERE CategoryId =?", t.getCategoryDesc() ,t.getCategoryName(),t.getCategoryId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM BookCategory WHERE CategoryId = ?", id);
    }

    @Override
    public BookCategoryEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM BookCategory WHERE CategoryId = ?", id);
        
        if(rst.next()){
            BookCategoryEntity bookCategoryEntity = new BookCategoryEntity(
                    rst.getString("CategoryName"), 
                    rst.getString("CategoryId"), 
                    rst.getString("CategoryDescription"));
            
            return bookCategoryEntity;
        }
        return null;
    }

    @Override
    public ArrayList<BookCategoryEntity> getAll() throws Exception {
        ArrayList<BookCategoryEntity> bookCategoryEntitys=new ArrayList<>();
        
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM BookCategory");
        
        while(rst.next()){
            BookCategoryEntity bookCategoryEntity = new BookCategoryEntity(
                    rst.getString("CategoryName"),
                    rst.getString("CategoryId"),
                    rst.getString("CategoryDescription"));
            bookCategoryEntitys.add(bookCategoryEntity);
        }
        
        return bookCategoryEntitys;
    }


    
}
