package product.model.dao;

import product.model.dto.ProductDto;

import java.util.ArrayList;

public class ProductDao {
    private ProductDao(){}
    private static final ProductDao instance=new ProductDao();
    public static ProductDao getInstance(){return instance;}
    private ArrayList<ProductDto> productLists=new ArrayList<>();
    private int productNo=0;
    // 게시물 등록 함수
    public boolean productadd(String product,int price,String content){
        productNo+=1;
        ProductDto productDto=new ProductDto(productNo,product,price,content);
        return productLists.add(productDto);
    }
    public int productSize() {return productLists.size();}
    public int getProductNo(int i) {return productLists.get(i).getProductNo();}
    public String getProductName(int i) {return productLists.get(i).getProduct();}
    public int getProductPrice(int i) {return productLists.get(i).getPrice();}
    public String getProductContent(int i) {return productLists.get(i).getContent();}

}
