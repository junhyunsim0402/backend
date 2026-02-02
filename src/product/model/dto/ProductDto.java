package product.model.dto;

public class ProductDto {
    private int productNo;
    private String product;
    private int price;
    private String content;
    public ProductDto() {}
    public ProductDto(int productNo, String product, int price, String content) {
        this.productNo = productNo;
        this.product = product;
        this.price = price;
        this.content = content;
    }
    public int getProductNo() { return productNo; }
    public void setProductNo(int productNo) { this.productNo = productNo; }
    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    @Override
    public String toString() {
        return "ProductDto{" +
                "productNo=" + productNo +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", content='" + content + '\'' +
                '}';
    }
}