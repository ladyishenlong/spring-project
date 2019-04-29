package com.ladyishenlong.springprojectmq.rabbit_mq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

/**
 * rabbit mq 事务
 */
public class RmqTransaction {


    private String TX_QUEUE="RmqTransaction";

    /**
     * 消息发送
     *
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     * @throws TimeoutException
     */
    public void publish()
            throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException {
        // 创建连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection conn = factory.newConnection();
        // 创建信道
        Channel channel = conn.createChannel();
        // 声明队列
        channel.queueDeclare(TX_QUEUE, true, false, false, null);

        try {

            long startTime = System.currentTimeMillis();

            for (int i = 0; i < 10; i++) {
                // 声明事务
                channel.txSelect();


                String message = String.format("时间 => %s", System.currentTimeMillis());
                // 发送消息
                channel.basicPublish("", TX_QUEUE, MessageProperties.PERSISTENT_TEXT_PLAIN,
                        message.getBytes("UTF-8"));


                // 提交事务
                channel.txCommit();
            }

            long endTime = System.currentTimeMillis();

            System.out.println("事务模式，发送10条数据，执行花费时间：" + (endTime - startTime) + "s");

        } catch (Exception e) {
            channel.txRollback();
        } finally {
            channel.close();
            conn.close();
        }
    }


    /**
     * 消费者，消息接受
     * @throws IOException
     * @throws TimeoutException
     * @throws InterruptedException
     */
    public void consume() throws IOException, TimeoutException, InterruptedException {
//
//        Connection conn = RabbitMqConnFactoryUtil.getRabbitConn();
//        Channel channel = conn.createChannel();
//        channel.queueDeclare(TX_QUEUE, true, false, false, null);
//        // 声明事务
//        channel.txSelect();
//        try {
//            //单条消息获取进行消费
//            GetResponse resp = channel.basicGet(TX_QUEUE, false);
//            String message = new String(resp.getBody(), "UTF-8");
//            System.out.println("收到消息：" + message);
//            //消息拒绝
//            // channel.basicReject(resp.getEnvelope().getDeliveryTag(), true);
//            // 消息确认
//            channel.basicAck(resp.getEnvelope().getDeliveryTag(), false);
//            // 提交事务
//            channel.txCommit();
//        } catch (Exception e) {
//            // 回滚事务
//            channel.txRollback();
//        } finally {
//            //关闭通道、连接
//            channel.close();
//            conn.close();
//        }
    }


}
