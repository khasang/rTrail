package io.khasang.rtrail.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Listener for creating and destroying sessions
 * Set the maximum inactive interval to 10 minutes
 *
 * @author Sokolov Denis
 */
@WebListener
public class HttpSessionListenerImpl implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setMaxInactiveInterval(10 * 60);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}