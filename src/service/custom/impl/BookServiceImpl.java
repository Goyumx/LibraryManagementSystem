/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.custom.impl;

import dao.DaoFactory;
import dao.custom.BookDao;
import dto.BookDto;
import entity.BookEntity;
import java.util.ArrayList;
import service.custom.BookService;

/**
 *
 * @author goyum
 */
public class BookServiceImpl implements BookService{
    
    private BookDao bookDao = (BookDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);

    @Override
    public String save(BookDto bookDto) throws Exception {
        BookEntity bookEntity= getBookEntity(bookDto);
        return bookDao.create(bookEntity)? "Success": "Fail";
    }

    @Override
    public String update(BookDto bookDto) throws Exception {
        BookEntity bookEntity = getBookEntity(bookDto);
        return bookDao.update(bookEntity)?"Success":"Fail";
    }

    @Override
    public String delete(String bookId) throws Exception {
        return bookDao.delete(bookId)?"Success":"Fail";
    }

    @Override
    public BookDto get(String bookId) throws Exception {
        BookEntity bookEntity = bookDao.get(bookId);
        if(bookEntity!=null){
            return getBookDto(bookEntity);
        }
        return null;
    }

    @Override
    public ArrayList<BookDto> getAll() throws Exception {
        ArrayList<BookEntity> bookEntitys = bookDao.getAll();
        if(bookEntitys!=null && !bookEntitys.isEmpty()){
            ArrayList<BookDto> bookDtos= new ArrayList<>();
            for (BookEntity bookEntityss : bookEntitys) {
                bookDtos.add(getBookDto(bookEntityss));
            }
            return bookDtos;
        }
        return null;
    }
    
    private BookEntity getBookEntity(BookDto bookDto){
        return new BookEntity(
                bookDto.getBookID(),
                bookDto.getBookTitle(), 
                bookDto.getCategoryId(),
                bookDto.getDescription(),
                bookDto.getStates());
    }
    
        private BookDto getBookDto(BookEntity bookEntity){
        return new BookDto(
                bookEntity.getBookID(),
                bookEntity.getBookTitle(), 
                bookEntity.getCategoryId(),
                bookEntity.getDescription(),
                bookEntity.getStates());
    }
    
}
