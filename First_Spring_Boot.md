# First_Spring_Boot

`IDEA` + `Maven`

## 初始项目

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

   - `NEW Class "Application"`

     ```java
     package hello;
     
     public class Application {
         public static void main(String[] args) {
             System.out.println("application");
             // 创建打印对象
             MessagePrinter printer = new MessagePrinter();
             // 创建消息服对象
             MessageService service = new MessageService();
             // 设置打印机对象的service属性
             printer.setService(service);
             // 打印消息
             printer.printMessage();
         }
     }
     ```

     

## 初始化Spring容器

1. `Class "MessageService"&"MessagePrinter"`

   添加`Component`注解,并添加无参构造方法（快捷键：`Ctrl+O` -->`Object`）用于打印输出。

   <!--@component 把普通pojo实例化到spring容器中-->

   ```java
   package hello;
   
   /**
    * 打印服务
    */
   
   import org.springframework.stereotype.Component;
   
   @Component
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

   ```java
   package hello;
   
   import org.springframework.stereotype.Component;
   
   /**
    * 消息打印机
    */
   @Component
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

2. `NEW Class "ApplicationSpring"`

   添加`ComponentScan`注解

   <!--ComponentScan主要就是定义扫描的路径从中找出标识了需要装配的类自动装配到spring的bean容器中-->

   ```java
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
   ```

   

## 获取Bean对象