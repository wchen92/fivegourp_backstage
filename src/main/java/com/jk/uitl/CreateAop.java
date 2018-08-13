package com.jk.uitl;

import org.springframework.amqp.core.AmqpTemplate;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/10 11:04
 * @ Description：
 * @ Version:
 */
public class CreateAop implements Runnable {

   private AmqpTemplate amqpTemplate;
   private String log;





    @Override
    public void run() {
        amqpTemplate.convertAndSend("wchenandliushun",log);
    }

    public CreateAop(AmqpTemplate amqpTemplate, String log){
        this.amqpTemplate=amqpTemplate;
        this.log=log;
    }

}
