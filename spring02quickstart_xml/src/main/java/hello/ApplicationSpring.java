package hello;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationSpring {
    public static void main(String[] args) {
        System.out.println("ApplicationSpring");
        // 初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        // 获取MessagePrint对象
        MessagePrinter printer = context.getBean(MessagePrinter.class);

        System.out.println(printer);

        // 打印消息
        printer.printMessage();
    }
}
