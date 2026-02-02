package 종합.과제3.controller;

import 종합.과제3.dao.BookDao;

import java.util.ArrayList;

public class BookController {
    private BookController(){}
    private static final BookController instance=new BookController();
    public static BookController getInstance(){return instance;}
    BookDao bd=BookDao.getInstance();
    private ArrayList<BookDao> bookList=new ArrayList<>();
    public boolean bookAdd(String book,int price){
        boolean bookResult=bd.bookAdd(book,price);
        return bookResult;
    }
    public int bookSize(){return bd.booksize();}
    public String bookname(int i){return bd.bookName(i);}
    public int bookprice(int i){return bd.bookPrice(i);}
}
