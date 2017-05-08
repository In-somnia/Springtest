package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.loggers.ConsoleEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;

    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        App app = (App)context.getBean("app");
        app.logEvent("Some event for 1");
        app.logEvent("Some event for 2");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        eventLogger.logEvent(message);
    }
}
