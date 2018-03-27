package com.example.t7830.test4;

/**
 * Created by t7830 on 2018/3/26.
 */

public class Book {
    private Boolean isHistory,isSuspense,isLiterary;
    private String book_name;
    private int age;
    private int image_id;

    public String getType(){
        if(isHistory){
            return "历史";
        }else if(isSuspense){
            return "悬疑";
        }else{
            return "文艺";
        }
    }

    public Book( String book_name, int age,int image_id,Boolean isHistory,Boolean isSuspense,Boolean isLiterary) {
        this.book_name = book_name;
        this.age = age;
        this.setImage_id(image_id);
        this.setHistory(isHistory);
        this.setSuspense(isSuspense);
        this.setLiterary(isLiterary);
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public Boolean getLiterary() {
        return isLiterary;
    }

    public void setLiterary(Boolean literary) {
        isLiterary = literary;
    }

    public Boolean getSuspense() {
        return isSuspense;
    }

    public void setSuspense(Boolean suspense) {
        isSuspense = suspense;
    }

    public Boolean getHistory() {
        return isHistory;
    }

    public void setHistory(Boolean history) {
        isHistory = history;
    }
}
