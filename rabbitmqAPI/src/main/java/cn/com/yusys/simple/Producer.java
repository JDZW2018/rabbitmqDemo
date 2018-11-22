package cn.com.yusys.simple;

import cn.com.yusys.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author Tianfusheng
 * @date 2018/11/22
 */
public class Producer {
    private final static String QUEUE_NAME = "test_queue";

    public static void main(String[] args) throws  Exception{
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        //获得通道
        Channel channel = connection.createChannel();
        // 声明（创建）队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 消息内容
        String message = "Hello World! -- 1";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("send: "+message);
        //发送过消息后记得关闭通道和连接，来释放资源否则通道和连接将一直是连接状态，main方法无法结束。
        channel.close();
        connection.close();
    }

}
