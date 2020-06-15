package testone;

import java.math.BigDecimal;

public class helloWorld {

    public static void main(String[] args) {
        /*System.out.println("第一种放在常量池中，第二种为引用");
        int a = 6;
        int b = 6;
        System.out.println(a==b);

        String aa = new String("aabb");
        String bb = new String("aabb");
        System.out.println(aa == bb);

        final int ME = 0;*/
        /*volatile int i = 5;*/
        for (int i = 0; i < 20; i ++){
            System.out.println(new BigDecimal(Long.MAX_VALUE));
        }
    }

}
