package com.example.Practice.PracticeProject.Model;

import java.util.Date;

public class UserBookMapping {
    private int id;
    private int book_id;
    private int user_id;
    private boolean isreturn;
    private Date issuedate;
    private Date returndate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isIsreturn() {
        return isreturn;
    }

    public void setIsreturn(boolean isreturn) {
        this.isreturn = isreturn;
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }
}
