package day6;

public class Product {
    String name;
    int stock;
    public boolean sell(int buy){
        if(stock-buy>0){
            stock-=buy;
            System.out.println("구매성공");
            return true;
        }else{
            System.out.println("재고부족");
            return false;
        }
    }
}
