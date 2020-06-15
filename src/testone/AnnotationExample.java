package testone;

public class AnnotationExample {
    @AnnotationDemo(value = {"hello","helloworld"},requestCode=15)
    public static void requestPermission(){
        System.out.println("测试注解");
    }
}
