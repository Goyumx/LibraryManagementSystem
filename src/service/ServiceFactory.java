/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import service.custom.impl.BookCategoryServiceImpl;
import service.custom.impl.BookProcessServiceImpl;
import service.custom.impl.BookServiceImpl;
import service.custom.impl.MemberServiceImpl;

/**
 *
 * @author goyum
 */
public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }
    
    public static ServiceFactory getInstance(){
        if (serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }
    
    public SuperService getService(ServiceType serviceType){
        switch(serviceType){
            case BOOK:
                return new BookServiceImpl();
            case BOOKCATEGORY:
                return new BookCategoryServiceImpl();
            case MEMBERS:
                return new MemberServiceImpl();
            case BOOK_PROCESS:
                return new BookProcessServiceImpl();
            default:
                return null;
        }
    }
    
    public enum ServiceType{
        BOOK , BOOKCATEGORY , MEMBERS , BOOK_PROCESS
    }
}
