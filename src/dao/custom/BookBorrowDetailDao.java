/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.custom;

import dao.CrudDao;
import entity.BookBorrowDetailEntity;
import java.util.ArrayList;


/**
 *
 * @author goyum
 */
public interface BookBorrowDetailDao extends CrudDao<BookBorrowDetailEntity, String>{
    ArrayList<BookBorrowDetailEntity> getBorrowDetailsByd(String borrowId) throws Exception;
}
