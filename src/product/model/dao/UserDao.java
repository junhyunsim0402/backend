package product.model.dao;

import product.model.dto.ProductDto;
import product.model.dto.UserDto;

import java.util.ArrayList;

public class UserDao {
    private UserDao() {}
    private static final UserDao instance = new UserDao();
    public static UserDao getInstance() {//싱글톤을 반환하는 메소드
        return instance;
    }
    private static final ArrayList<UserDto> userLists = new ArrayList<>();
    private static int userNo = 100;

    //회원가입 등록 함수
    public boolean userAdd(String id, int pwd, String nickname , String phone) {
        UserDto userDto = new UserDto(userNo, id , pwd , nickname , phone);
        boolean userResult = userLists.add(userDto);
        userNo++;
        return userResult;
    }
    //반환
    public ArrayList<UserDto> userdoGet(){
        return userLists ;
    }
    //로그인 성공 시 닉네임 반환 함수
    public String  login(String id,int pwd){
        for(int i=0;i<userLists.size();i++){
            UserDto userDto=userLists.get(i);
            if(userDto.getId().equals(id)&&userDto.getPwd()==pwd){
                return userDto.getNickname();
            }
        }
        return "로그인실패";
    }
}
