package 종합.과제3.dao;

import day7.package1.B;
import 종합.과제3.dto.BookDto;

import java.util.ArrayList;

public class BookDao {
    private BookDao(){}
    private static final BookDao instance=new BookDao();
    public static BookDao getInstance(){return instance;}
    private static int booknum=200;
    private ArrayList<BookDto> books=new ArrayList<>();
    public boolean bookAdd(String book,int price){
        BookDto bookDto=new BookDto(book,booknum,price);
        boolean bookResult=books.add(bookDto);
        if(bookResult) {
            booknum += 1;
        }
        return bookResult;
    }
    public int booksize(){return books.size();}
    public String bookName(int i){return books.get(i).getBook();}
    public int bookPrice(int i){return books.get(i).getPrice();}
}
