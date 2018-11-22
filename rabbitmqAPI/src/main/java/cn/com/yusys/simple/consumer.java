package cn.com.yusys.simple;

import cn.com.yusys.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @author Tianfusheng
 * @date 2018/11/22
 */
public class consumer {
    private final static String QUEUE_NAME = "test_queue";

    public static void main(String[] args) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列
        channel.basicConsume(QUEUE_NAME,consumer);

        while (true){
            System.out.println("------beginning------");
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.out.println("Recv: "+msg);
        }


    }

}
