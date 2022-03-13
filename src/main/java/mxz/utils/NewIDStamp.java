package mxz.utils;

public class NewIDStamp {
    public static String createNewIDStamp() {
        Long microsecond = System.nanoTime() / 1000 % 1000000;
        String timeStamp = System.currentTimeMillis() / 1000L + (microsecond < 100000?"0":"") + microsecond;
        return "邮政编码" + timeStamp;
    }
}
