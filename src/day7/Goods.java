package day7;

public class Goods {
    String name;
    int price;
    public Goods(){
        this.name="미정";
        this.price=0;
    }
    public Goods(String name,int price){
        this.name=name;
        this.price=price;
    }
    public void printGoods(){
        System.out.println(name+price);
    }
}
