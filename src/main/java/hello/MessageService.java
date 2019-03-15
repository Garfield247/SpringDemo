package hello;

/**
 * 打印服务
 */

import org.springframework.stereotype.Component;

@Component
public class MessageService {
    /**
     * 执行打印功能
     * @return 要打印的字符串
     */
    public String getMessage(){
        return "HELLO WORLD";
    }
}
