package cn.com.yusys.sendTest;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Tianfusheng
 * @date 2018/11/18
 */
@Controller
public class SendTest {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void send(String msg) {
    }

}
