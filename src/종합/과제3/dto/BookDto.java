package 종합.과제3.dto;

import day7.Book;

public class BookDto {
    private String Book;
    private int booknum;
    private int price;
    public BookDto(String book, int booknum, int price){this.Book=book;this.booknum=booknum;this.price=price;}
    public String getBook() {return Book;}
    public void setBook(String book) {Book = book;}
    public int getBooknum() {return booknum;}
    public void setBooknum(int booknum) {this.booknum = booknum;}
    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}
    @Override
    public String toString() {
        return "BookDto{" +
                "Book='" + Book + '\'' +
                ", booknum=" + booknum +
                ", price=" + price +
                '}';
    }
}
