package com.hexagonalexample.infrastructure.notification.inmemory.email;

import com.hexagonalexample.domain.common.emailnotification.EmailNotificationPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class EmailNotoficationAdapter implements EmailNotificationPort {

    private static Logger log = LoggerFactory.getLogger(EmailNotoficationAdapter.class);

    @Override
    public void send(List<String> recipients, String message) {
        log.info("Sending email notification in memory: " + recipients + " " + message);
    }
}
