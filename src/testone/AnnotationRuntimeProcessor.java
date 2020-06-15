package testone;

import java.lang.reflect.Method;

public class AnnotationRuntimeProcessor {
    public static void main(String[] args) {
        System.out.println("00000000000000000000");
        try{
            AnnotationExample.requestPermission();
            Class<?> cls = Class.forName("testone.AnnotationExample");

            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                boolean isHasAnno = method.isAnnotationPresent(AnnotationDemo.class);
                System.out.println(method.getName());
                if (isHasAnno) {

                    method.setAccessible(true);
                    AnnotationDemo ad = method.getAnnotation(AnnotationDemo.class);
                    if (ad == null) {
                        return;
                    }
                    String[] s = ad.value();
                    System.out.println("value" + s);
                    int code = ad.requestCode();
                    System.out.println(code);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("1111111");
    }
}
