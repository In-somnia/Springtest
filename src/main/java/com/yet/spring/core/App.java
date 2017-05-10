package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.loggers.ConsoleEventLogger;
import com.yet.spring.core.loggers.EventLogger;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private Map<EventType, EventLogger> loggers;
    private EventLogger defaultLogger;

    public App(Client client, ConsoleEventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        App app = (App)context.getBean("app");

        Event event = context.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for 1");

        event = context.getBean(Event.class);
        app.logEvent(null, event, "Some event for 2");

        event = context.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Some event for 3");

        event = context.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for 3");

        event = context.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Some event for 5");

        event = context.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for 6");

        context.close();
    }

    private void logEvent(EventType eventType, Event event, String msg) {

        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }
}
