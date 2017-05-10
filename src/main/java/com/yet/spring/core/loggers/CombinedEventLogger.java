package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger {
    private Collection<Object> loggers;

    public CombinedEventLogger(Collection<Object> loggers) {
        this.loggers = loggers;
    }
    @Override
    public void logEvent(Event event) {
        for (Object logger : loggers) {

        }

    }
}
