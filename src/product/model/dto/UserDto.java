package product.model.dto;

public class UserDto {
    private int userNo;
    private String id;
    private int pwd;
    private String nickname;
    private String phone;
    public UserDto() {}
    public UserDto(int userNo, String id, int pwd, String nickname, String phone) {
        this.userNo = userNo;
        this.id = id;
        this.pwd = pwd;
        this.nickname = nickname;
        this.phone = phone;
    }
    public int getUserNo() { return userNo; }
    public void setUserNo(int userNo) { this.userNo = userNo; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getPwd() { return pwd; }
    public void setPwd(int pwd) { this.pwd = pwd; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    @Override
    public String toString() {
        return "UserDto{" +
                "userNo=" + userNo +
                ", id='" + id + '\'' +
                ", pwd=" + pwd +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}