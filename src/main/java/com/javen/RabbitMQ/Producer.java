package com.javen.RabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zcd
 * @description:
 * @create 2020/1/12 14:54
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建一个连接工厂,并进行配置
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.11.76");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        //通过连接工厂,创建一个连接
        Connection connection = connectionFactory.newConnection();
        //通过连接创建通道
        Channel channel = connection.createChannel();
        String msg = "Hello RabbitMQ";
        String queue_name = "test001";
        //声明一个队列   declare : 声明
        channel.queueDeclare(queue_name,false,false,false,null);
        //推送消息
        for (int i=0 ; i<=5; i++) {
            //@param 1.exchange  2. routing Key
            //exchange为空,即default exchange 这种路由键和队列名相同即可路由过去,否则删除
            channel.basicPublish("", "queue_name", null, msg.getBytes());
        }
        channel.close();
        connection.close();

    }

}
