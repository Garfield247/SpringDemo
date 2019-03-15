package hello;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class ApplicationSpring {
    public static void main(String[] args) {
        System.out.println("ApplicationSpring");
        // 初始化Spring容器
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationSpring.class);
    }
}
