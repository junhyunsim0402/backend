package 종합.과제3.dto;

public class UserDto {
    private int usernum;
    private String id;
    private int pwd;
    private String nickname;
    private String adminId="admin";
    private int adminPwd=1234;
    public String getAdminId() {return adminId;}
    public void setAdminId(String adminId) {this.adminId = adminId;}
    public int getAdminPwd() {return adminPwd;}
    public void setAdminPwd(int adminPwd) {this.adminPwd = adminPwd;}
    public UserDto(int usernum, String id, int pwd, String nickname){
        this.usernum=usernum;this.id=id;this.pwd=pwd;this.nickname=nickname;
    }
    public int getUsernum() {return usernum;}
    public void setUsernum(int usernum) {this.usernum = usernum;}
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public int getPwd() {return pwd;}
    public void setPwd(int pwd) {this.pwd = pwd;}
    public String getNickname() {return nickname;}
    public void setNickname(String nickname) {this.nickname = nickname;}
    @Override
    public String toString() {
        return "UserDto{" +
                "usernum=" + usernum +
                ", id='" + id + '\'' +
                ", pwd=" + pwd +
                ", nickname='" + nickname + '\'' +
                ", adminId='" + adminId + '\'' +
                ", adminPwd=" + adminPwd +
                '}';
    }
}
