/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author goyum
 */
public class BookBorrowEntity {
    
    private String borrowId;
    private String memberId;
    private String borrowDate;
    private String dueDate;
    private String returnDate;
    private double fines;

    public BookBorrowEntity() {
    }
    
    public BookBorrowEntity(String borrowId, String memberId, String borrowDate, String dueDate ) {
        this.borrowId = borrowId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        
    }

    public BookBorrowEntity(String borrowId, String memberId, String borrowDate, String dueDate, String returnDate, double fines) {
        this.borrowId = borrowId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.fines = fines;
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

    @Override
    public String toString() {
        return "BookBorrowEntity{" + "borrowId=" + borrowId + ", memberId=" + memberId + ", borrowDate=" + borrowDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate + ", fines=" + fines + '}';
    }

    
    
    
    
}
