package Project1.controller;
import java.util.ArrayList;

import Project1.model.dao.ProductDao;
import Project1.model.dto.ProductDto;

public class ProductController {
    public static final ProductController instance = new ProductController();
    private ProductDao pd = ProductDao.getInstance();

    private ProductController() {
    }

    public static ProductController getInstance() {
        return instance;
    }

    public boolean write(String nickname, String product, String content, int price, String pwd, String phone) {
        ProductDto dto = new ProductDto(0, nickname, product, content, price, pwd, phone, "판매중", "");
        return this.pd.register(dto);
    }

    public ArrayList<ProductDto> findAll() {
        return this.pd.getList();
    }

    public int update(int pno, String pwd, String productName, int price, String contact, String status) {
        ProductDto dto = new ProductDto();
        dto.setProductNo(pno);
        dto.setProduct(productName);
        dto.setPrice(price);
        dto.setContact(contact);
        dto.setStatus(status);
        return this.pd.update(dto, pwd);
    }

    public int delete(int pno, String pwd) {
        return this.pd.delete(pno, pwd);
    }
}

