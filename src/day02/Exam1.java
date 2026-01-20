package day02;

public class Exam1 {
    public static void main(String[] args) {
        // [1]타입=자료형=분류=자료들을 분류/나누는 방법
        // (1)자동 타입 변환(묵시적:개발자가 따로 할게 없다)
        // byte->short->int->long->float->double(작은 상자->큰 상자)
        byte byteValue=10; //10 자료를 byte로 분류함
        short shortValue=byteValue; //byte->short타입으로 변환
        int intValue=shortValue;
        long longValue=intValue;
        float floatValue=longValue;
        double doubleValue=floatValue; //작은 범위에서 큰 범위로 변환 가능

        //(2)연상중 (자동) 타입 변환,
        // byte+byte=int, byte+short=int, int+int=int, int이하의 피연산자들은 연산하면 int임
        // long/float/double 들은 피연산자 중에 더 큰 타입으로 결과
        byte b1=10; byte b2=20; short s1=30; int i=40; long l1=50; float f1=3.14f; double d1=41.25;
        int result1=b1+b2; //byte+byte=int
        int result2=b1+s1; //byte+short=int
        long result3=i+l1; //int+long=long
        float result4=i+f1; // int+float=float
        double result5=d1+i; // double+int=double

        //(3)강제 타입 변환/캐스팅(명시적:개발자가 변환할 타입 작성), 손실 있다
        // double->float->long->int->short->byte(큰 상자->작은 상자)
        double dv=3.14;
        float fv=(float)dv;
        int iv=(int)fv;
        short sv=(short)iv;
        byte bv=(byte)sv;
    }
}
