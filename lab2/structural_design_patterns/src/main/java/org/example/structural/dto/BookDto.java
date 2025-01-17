package org.example.structural.dto;

import lombok.Data;

@Data
public class BookDto {
    private String title;
    private String author;
    private double price;
    private boolean isFeatured;

    public boolean getIsFeatured(){
        return isFeatured;
    }

    public void setIsFeatured(boolean flag){
        isFeatured = flag;
    }

}
