package Project1.model.dto;

public class ProductDto {
    private int productNo;
    private String nickname;
    private String product;
    private String content;
    private int price;
    private String password;
    private String contact;
    private String status;
    private String regDate;

    public ProductDto() {
    }

    public ProductDto(int productNo, String nickname, String product, String content, int price, String password, String contact, String status, String regDate) {
        this.productNo = productNo;
        this.nickname = nickname;
        this.product = product;
        this.content = content;
        this.price = price;
        this.password = password;
        this.contact = contact;
        this.status = status;
        this.regDate = regDate;
    }

    public int getProductNo() {
        return this.productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegDate() {
        return this.regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String toString() {
        return "ProductDto{no=" + this.productNo + ", 작성자='" + this.nickname + "', 물품='" + this.product + "', 가격=" + this.price + ", 상태='" + this.status + "', 등록일='" + this.regDate + "'}";
    }
}
