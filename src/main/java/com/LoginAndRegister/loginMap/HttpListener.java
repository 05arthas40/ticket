package com.LoginAndRegister.loginMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    /**
     * 监听session动作，当session销毁时，要把map集合中相应的session清空
     * @param httpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        String sessionid = httpSessionEvent.getSession().getId();
        UserloginMap.romvelogininfo(sessionid);
    }
}
