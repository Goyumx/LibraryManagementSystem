/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author goyum
 */
public class BookBorrowDetailDto {
    
    private String borrowId;
    private String bookId;
    private String dueDate;

    public BookBorrowDetailDto() {
    }

    public BookBorrowDetailDto(String borrowId, String bookId, String dueDate) {
        this.borrowId = borrowId;
        this.bookId = bookId;
        this.dueDate = dueDate;
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
     * @return the bookId
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(String bookId) {
        this.bookId = bookId;
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

    @Override
    public String toString() {
        return "BookBorrowDetailDto{" + "borrowId=" + borrowId + ", bookId=" + bookId + ", dueDate=" + dueDate + '}';
    }
    
    
    
}
