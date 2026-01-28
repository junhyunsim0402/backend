package day7;

public class Book {
    String title;
    String author;
    int price;
    public Book(String title,String author,int price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    public void printInfo(){
        System.out.printf("제목:%s,저자:%s,가격:%d\n",title,author,price);
    }
}