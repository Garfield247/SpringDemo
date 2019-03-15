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
