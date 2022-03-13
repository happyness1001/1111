package gsh.utils;

public class TimeStamp {

    public static void main(String[] args) {
//        生成时间戳
        long l = System.currentTimeMillis() * 1000L + (System.nanoTime() % 1000L);
        System.out.println(String.valueOf(l).length());
        System.out.println(l);
    }

}
