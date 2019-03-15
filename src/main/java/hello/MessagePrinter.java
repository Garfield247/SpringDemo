package hello;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    public void setService(MessageService service) {

        this.service = service;
    }

    public void printMessage(){
        System.out.println(this.service.getMessage());
    }
}
