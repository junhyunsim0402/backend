package product.controller;

import product.model.dao.ProductDao;
import product.model.dto.ProductDto;

import java.util.ArrayList;

public class ProductController {
    private ProductController(){}
    private static final ProductController instance=new ProductController();
    public static ProductController getInstance(){return instance;}
    private ProductDao pd=ProductDao.getInstance();
    //물품 등록 함수
    public int productSize() { return pd.productSize(); }
    public int getProductNo(int i) { return pd.getProductNo(i); }
    public String getProductName(int i) { return pd.getProductName(i); }
    public int getProductPrice(int i) { return pd.getProductPrice(i); }
    public String getProductContent(int i) { return pd.getProductContent(i); }

    public boolean productadd(String product, int price, String content) {
        return pd.productadd(product, price, content);
    }
}
