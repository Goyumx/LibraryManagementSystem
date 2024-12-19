/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author goyum
 */
public class BookEntity {
    
    private String bookID;
    private String bookTitle;
    private String categoryId;
    private String description;
    private String states;

    public BookEntity() {
    }

    public BookEntity(String bookID, String bookTitle, String categoryId, String description, String states) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.categoryId = categoryId;
        this.description = description;
        this.states = states;
    }

    /**
     * @return the bookID
     */
    public String getBookID() {
        return bookID;
    }

    /**
     * @param bookID the bookID to set
     */
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    /**
     * @return the bookTitle
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * @param bookTitle the bookTitle to set
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the states
     */
    public String getStates() {
        return states;
    }

    /**
     * @param states the states to set
     */
    public void setStates(String states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "BookEntity{" + "bookID=" + bookID + ", bookTitle=" + bookTitle + ", categoryId=" + categoryId + ", description=" + description + ", states=" + states + '}';
    }
       
}
