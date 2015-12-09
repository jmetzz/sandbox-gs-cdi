package com.github.jmetzz.concurrency.timer;

import com.sun.istack.internal.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.*;

/**
 * Created by Jean Metz.
 */

@Stateless
public class TimerSessionBean {

    public static final Logger logger = Logger.getLogger(TimerSessionBean.class);

    @Resource
    private TimerService timerService;

    @Resource
    private SessionContext context;

    public void createTimer(long duration) {
        context.getTimerService().createTimer(duration, "Hello World!");
    }

    public void createTimer() {
        /// use timerService to create a timer object
    }


    @Timeout
    public void timeOutHandler(Timer timer) {


        System.out.println("timeoutHandler : " + timer.getInfo());
        timer.cancel();
    }
}
