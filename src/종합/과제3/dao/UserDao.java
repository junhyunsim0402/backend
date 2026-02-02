package 종합.과제3.dao;

import 종합.과제3.dto.UserDto;

import java.util.ArrayList;

public class UserDao {
    private UserDao(){}
    private static final UserDao instance=new UserDao();
    public static UserDao getInstance(){return instance;}
    private static int usernum=101;
    private ArrayList<UserDto> userLists=new ArrayList<>();
    public boolean userAdd(String id,int pwd,String nickname){
        UserDto userDto=new UserDto(usernum,id,pwd,nickname);
        boolean userResult=userLists.add(userDto);
        usernum+=1;
        return userResult;
    }
    public String login(String id,int pwd){
        if("admin".equals(id)&&pwd==1234) {
            return "관리자";
        }
        for(int i=0;i<userLists.size();i++) {
            UserDto userDto = userLists.get(i);
            if (userDto.getId().equals(id) && userDto.getPwd() == pwd) {
                return userDto.getNickname();
            }
        }
        return "로그인 실패";
    }
}
