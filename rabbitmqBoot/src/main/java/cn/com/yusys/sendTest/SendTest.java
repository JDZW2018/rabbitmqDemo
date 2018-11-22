package cn.com.yusys.sendTest;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SendTest {
    @Autowired
    private AmqpTemplate template;

    @ResponseBody
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String demo(String msg) {
        template.convertAndSend("testExchange", "testRoutingKey", msg);
        return "success";
    }
}
