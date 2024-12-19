/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author goyum
 */
public class BookBorrowDto {
    
    private String borrowId;
    private String memberId;
    private String borrowDate;
    private String dueDate;
    private String returnDate;
    private double fines;
    
    private ArrayList<BookBorrowDetailDto> bookBorrowDetailDtos;

    
    
    
    public BookBorrowDto() {
    }
    
    public BookBorrowDto(String borrowId, String memberId, String borrowDate, String dueDate, ArrayList<BookBorrowDetailDto> bookBorrowDetailDtos) {
        this.borrowId = borrowId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.bookBorrowDetailDtos = bookBorrowDetailDtos;
    }
    
    public BookBorrowDto(String borrowId, String memberId, String borrowDate, String dueDate, String returnDate, double fines, ArrayList<BookBorrowDetailDto> bookBorrowDetailDtos) {
        this.borrowId = borrowId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.fines = fines;
        this.bookBorrowDetailDtos = bookBorrowDetailDtos;
    }

    /**
     * @return the borrowId
     */
    public String getBorrowId() {
        return borrowId;
    }

    /**
     * @param borrowId the borrowId to set
     */
    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    /**
     * @return the memberId
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the borrowDate
     */
    public String getBorrowDate() {
        return borrowDate;
    }

    /**
     * @param borrowDate the borrowDate to set
     */
    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    /**
     * @return the dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return the fines
     */
    public double getFines() {
        return fines;
    }

    /**
     * @param fines the fines to set
     */
    public void setFines(double fines) {
        this.fines = fines;
    }

    /**
     * @return the bookBorrowDetailDtos
     */
    public ArrayList<BookBorrowDetailDto> getBookBorrowDetailDtos() {
        return bookBorrowDetailDtos;
    }

    /**
     * @param bookBorrowDetailDtos the bookBorrowDetailDtos to set
     */
    public void setBookBorrowDetailDtos(ArrayList<BookBorrowDetailDto> bookBorrowDetailDtos) {
        this.bookBorrowDetailDtos = bookBorrowDetailDtos;
    }

    @Override
    public String toString() {
        return "BookBorrowDto{" + "borrowId=" + borrowId + ", memberId=" + memberId + ", borrowDate=" + borrowDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate + ", fines=" + fines + ", bookBorrowDetailDtos=" + bookBorrowDetailDtos + '}';
    }
    
    
    
    
}
