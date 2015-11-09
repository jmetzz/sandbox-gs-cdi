package com.github.jmetzz.cdi.service.interceptors;


import com.github.jmetzz.cdi.service.annotations.Loggable;

import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;


/**
 * Created by Jean Metz on 15-Oct-15.
 */

/*
Interceptors are defined in their own specification (JSR 318)
But the CDI specification has extended it by adding interceptor
binding, meaning that interceptor binding can only be used
if CDI is enabled.
*/
@Interceptor
@Loggable //binds the interceptor to beans annotated with this binding annotation
public class LoggingInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {

        logger.entering(ic.getTarget().getClass().getName(), ic.getMethod().getName());

        try {
            return ic.proceed();
        } finally {
            logger.exiting(ic.getTarget().getClass().getName(), ic.getMethod().getName());
        }

    }

    @AroundConstruct
    public void init(InvocationContext ic) throws Exception {
        logger.info("Entering constructor");
        try {
            ic.proceed();
        } finally {
            logger.info("Exiting constructor");
        }
    }
}
