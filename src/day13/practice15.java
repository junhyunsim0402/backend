package day13;

import 종합.과제3.dto.BookDto;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class practice15 {
    public static void main(String[] args) {
        /*[실습] 제출용 */

        /*[문제 1] BookDto는 toString()을 오버라이딩하지 않고 BoardDto는 toString()을 오버라이딩하도록 만든 뒤 Object 타입 변수에 저장하여 두 객체를 하나의 출력문으로 출력했을 때 결과 차이가 나타나게 만드세요.
        [출력예시]
        day.BookDto@7cca494b | BoardDto{...}
        */
        System.out.println("[문제1]");
        Object book = new bookDto("자바의 정석");
        Object board = new BoardDto("공지사항");
        System.out.println(book + " | " + board);

        /*[문제 2] new String("유재석")으로 생성한 두 객체의 == 와 equals() 비교 결과를  출력하시오.
        [출력예시]
        == 비교:false, equals 비교:true
        */
        System.out.println("[문제2]");
        String name1=new String("유재석");
        String name2=new String("유재석");
        System.out.println(name1==name2);
        System.out.println(name1.equals(name2));
        /*[문제 3] Class 리플렉션
        1. String 객체를 하나 생성하고 getClass()를 이용하여 클래스 타입 정보를 가져오세요.
        2. Class.forName("java.lang.String")을 사용하여 String 클래스를 직접 로드하세요.
        3. 로드된 Class 객체에서 getMethods()를 사용하여 메소드 개수를 구하세요.
        4. 위 결과들을  출력하시오.
        [출력예시]
        class java.lang.String | forName 성공 | method count:90
        */
        String refulection = new String();
        Class c1 = refulection.getClass();
        try {
            System.out.println("[문제3]");
            Class cls2=Class.forName("java.lang.String");
            Method[] methods=cls2.getMethods();
            int count=methods.length;
            System.out.printf("%s | forName성공 | method cound:%d\n",cls2,count);
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }


        /*[문제 4] 문자열 "100"과 "3.14"를 각각 기본타입으로 변환하고 기본타입을 문자열로 변환하는 방법을 포함하여 출력하시오.
        [출력예시]
        int:100, double:3.14, str1:"100", str2:"100"
        */
        System.out.println("[문제4]");
        String str1="100";int num1 = Integer.parseInt(str1);
        String str2="3.14";double num2=Double.parseDouble(str2);
        String re1=String.valueOf(num1);String re2=String.valueOf(num2);
        System.out.printf("int:%d, double:%f, str1:%s, str2:%s\n",num1,num2,re1,re2);
        /*[문제 5] LocalDateTime.now()로 현재 날짜/시간을 생성하고 지정된 포맷으로 변환 후 +10일, -30일 계산 결과를  출력하시오.
        [출력예시]
        현재:2025년 07월 25일 11:43:11 | +10일:2025-08-04T11:43:11 | -30일:2025-06-25T11:43:11
        */
        System.out.println("[문제5]");
        LocalDateTime localDateTime=LocalDateTime.now();
        int year=localDateTime.getYear();int month=localDateTime.getMonthValue();int day=localDateTime.getDayOfMonth();
        int hour=localDateTime.getHour();int minute=localDateTime.getMinute();int second=localDateTime.getSecond();
        LocalDateTime dateTime=LocalDateTime.of(year,month,day,hour,minute,second);
        System.out.printf("현재:%d년 %d월 %d일 %d:%d:%d | +10일:",year,month,day,hour,minute,second);
        System.out.printf("%s",dateTime.plusDays(10));
        System.out.printf(" | -30일:%s",dateTime.minusDays(30));
    }
}
class bookDto{
    private String title;
    public bookDto(String title) {this.title = title;}
}
class BoardDto{
    private String subject;
    public BoardDto(String subject) {this.subject = subject;}
    @Override
    public String toString() {return "BoardDto{subject='" + subject + "'}";}
}