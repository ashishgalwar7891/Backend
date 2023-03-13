package com.example.MailService.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = "mail_queue")
    public void getDtoFromQueue(EmailDTO emailDTO)
    {
        System.out.println(emailDTO.getRegistered_email());
        System.out.println(emailDTO.getSubject());
        System.out.println(emailDTO.getBody());
    }

}
