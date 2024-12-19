/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.custom.impl.BookBorrowDaoImpl;
import dao.custom.impl.BookBorrowDetailDaoImpl;
import dao.custom.impl.BookCategoryDaoImpl;
import dao.custom.impl.BookDaoImpl;
import dao.custom.impl.MemberDaoImpl;

/**
 *
 * @author goyum
 */
public class DaoFactory {
    
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }
    
    public static DaoFactory getInstance(){
        if(daoFactory==null){
            daoFactory= new DaoFactory();
        }
        return daoFactory;
    }
    
    public SuperDao getDao(DaoTypes daoTypes){
        switch (daoTypes){
            case BOOK:
                return new BookDaoImpl();
            case BOOKCATEGORY:
                return new BookCategoryDaoImpl();
            case MEMBERS:
                return new MemberDaoImpl();
            case BOOKBORROW:
                return new BookBorrowDaoImpl();
            case BOOKBORROWDETAIL:
                return new BookBorrowDetailDaoImpl();
            default:
                return null;
        }
    }
    
    public enum DaoTypes{
        BOOK , BOOKCATEGORY , MEMBERS , BOOKBORROW, BOOKBORROWDETAIL
    }
}
