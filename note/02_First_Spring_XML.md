1. 创建maven项目

   `Created New Project` ==> `Maven` ==> `SELECT "JDK"` ==> `INPUT "GroupId&ArtifactId"` ==> `INPUT "ProjectNmame&ProjectLocation"` ==> `Finsh`

2. 配置`pom.xml`

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
       <modelVersion>4.0.0</modelVersion>
   
       <groupId>com.SpringBootDemo</groupId>
       <artifactId>spring01quickstart</artifactId>
       <version>1.0-SNAPSHOT</version>
   
       <dependencies>
           <dependency>
               <groupId>org.springframework</groupId>
               <artifactId>spring-context</artifactId>
               <version>4.3.13.RELEASE</version>
           </dependency>
       </dependencies>
   </project>
   ```

3. 编码

   `【src/main/java】` ==> `NEW Package "hello"` 

   - `NEW Class "MessageService"`

     ```java
     package hello;
     
     /**
      * 打印服务
      */
     
     public class MessageService {
         /**
          * 无参构造方法
          * 用于打印输出
          */
         public MessageService() {
             super();
             System.out.println("MessageService");
         }
     
         /**
          * 执行打印功能
          * @return 要打印的字符串
          */
         public String getMessage(){
             return "HELLO WORLD";
         }
     }
     
     ```

   - `NEW Class "MessagePrinter"`

     ```java
     package hello;
     
     /**
      * 消息打印机
      */
     
     public class MessagePrinter {
         /**
          * 无参构造方法
          * 用于打印输出
          */
         public MessagePrinter() {
             super();
             System.out.println("MessagePrinter");
         }
     
         /**
          * 建立message和service的关联方式
          */
     
         private MessageService service;
     
         /**
          * 设置message的值
          * 快捷键：Alt+Inster --> Seater
          * @param service
          */
         public void setService(MessageService service) {
     
             this.service = service;
         }
     
         public void printMessage(){
             System.out.println(this.service.getMessage());
         }
     }
     
     ```

   - `NEW XML"resources/applicationcontext.xml"`

     ```xml
     <?xml version="1.0" encoding="utf-8" ?>
     <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsl="http://www.w3.org/2001/XMLSchema-instance"
            xsl:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
     
         <!--
             bean元素：描述当前的对象需要有Spring容器管理
             id属性： 标识对象，未来在应用程序中可以根据ID获取对象
             Class属性：被管理对象的类全名
         -->
         <bean id="service" class="hello.MessageService"></bean>
     
         <bean id="printer" class="hello.MessagePrinter">
             <property name="service" ref="service"></property>
         </bean>
     </beans>
     
     
     ```

   - `NEW Class "ApplicationSpring"`

     ```java
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
     
     ```