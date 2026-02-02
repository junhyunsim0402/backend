package 종합.과제2.model.dto;

public class WaitingDto {
    private String phone;
    private int count;
    private int no;
    public WaitingDto(){}
    public WaitingDto(int no, String phone, int count){
        this.no=no;
        this.phone=phone;
        this.count=count;
    }
    public int getNo() {return no;}
    public void setNo(int no) {this.no = no;}
    public int getCount() {return count;}
    public void setCount(int count) {this.count = count;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    @Override
    public String toString() {
        return "WaitingDto{" +
                "phone='" + phone + '\'' +
                ", count=" + count +
                ", no=" + no +
                '}';
    }
}