package cn.com.yusys.cosumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CosumerTest {

    @Autowired
    private CosumerTest cosumerTest;

    @RabbitListener(queues = "testQueues")
    public void demo(String msg){
        System.out.println(msg);
    }
}
