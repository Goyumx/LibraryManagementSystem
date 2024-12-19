/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.custom.impl;

import dao.DaoFactory;
import dao.custom.BookCategoryDao;
import dto.BookCategoryDto;
import entity.BookCategoryEntity;
import java.util.ArrayList;
import service.custom.BookCategoryService;


/**
 *
 * @author goyum
 */
public class BookCategoryServiceImpl implements BookCategoryService{
    
    private BookCategoryDao bookCategoryDao = (BookCategoryDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOKCATEGORY);
    
    @Override
    public String save(BookCategoryDto bookCategoryDto) throws Exception {
        BookCategoryEntity bookCategoryEntity = getBookCategoryEntity(bookCategoryDto);
        return bookCategoryDao.create(bookCategoryEntity)? "Success": "Fail";
    }

    @Override
    public String update(BookCategoryDto bookCategoryDto) throws Exception {
        BookCategoryEntity bookCategoryEntity = getBookCategoryEntity(bookCategoryDto);
        return bookCategoryDao.update(bookCategoryEntity)? "Success": "Fail";
    }

    @Override
    public String delete(String bookCategoryId) throws Exception {
        return bookCategoryDao.delete(bookCategoryId)?"Success":"Fail";
    }

    @Override
    public BookCategoryDto get(String bookCategoryId) throws Exception {
        BookCategoryEntity bookCategoryEntity = bookCategoryDao.get(bookCategoryId);
        if(bookCategoryEntity!=null){
            return getBookCategoryDto(bookCategoryEntity);
        }
        return null;
    }

    @Override
    public ArrayList<BookCategoryDto> getAll() throws Exception {
        ArrayList<BookCategoryEntity> bookCategoryEntitys = bookCategoryDao.getAll();
        if(bookCategoryEntitys!=null && !bookCategoryEntitys.isEmpty()){
            ArrayList<BookCategoryDto> bookCategoryDtoss = new ArrayList<>();
            for(BookCategoryEntity bookCategoryEntityss : bookCategoryEntitys){
                bookCategoryDtoss.add(getBookCategoryDto(bookCategoryEntityss));
            }
            return bookCategoryDtoss;
    }
        return null;
    }
    
    private BookCategoryEntity getBookCategoryEntity(BookCategoryDto bookCategoryDto){
        return new BookCategoryEntity(
                
                bookCategoryDto.getCategoryId(),
                bookCategoryDto.getCategoryName(),
                bookCategoryDto.getCategoryDesc());
                
    }
    
    private BookCategoryDto getBookCategoryDto(BookCategoryEntity bookCategoryEntity){
        return new BookCategoryDto(
             
                bookCategoryEntity.getCategoryName(), 
                bookCategoryEntity.getCategoryId(),
                bookCategoryEntity.getCategoryDesc());
        
    }
}
