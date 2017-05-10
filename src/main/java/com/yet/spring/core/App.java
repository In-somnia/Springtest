package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.loggers.ConsoleEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;

    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        App app = (App)context.getBean("app");

        Event event = context.getBean(Event.class);
        app.logEvent(event, "Some event for 1");

        event = context.getBean(Event.class);
        app.logEvent(event, "Some message for 2");

        event = context.getBean(Event.class);
        app.logEvent(event, "Some message for 3");

        event = context.getBean(Event.class);
        app.logEvent(event, "Some message for 4");

        event = context.getBean(Event.class);
        app.logEvent(event, "Some message for 5");

        event = context.getBean(Event.class);
        app.logEvent(event, "Some message for 6");

        context.close();

    }

    private void logEvent(Event event, String msg) {
        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }
}
